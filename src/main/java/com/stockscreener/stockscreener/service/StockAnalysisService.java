package com.stockscreener.stockscreener.service;

import com.stockscreener.stockscreener.component.DeepSeekClient;
import com.stockscreener.stockscreener.domain.entity.StockAnalysis;
import com.stockscreener.stockscreener.exception.StockAnalysisException;
import com.stockscreener.stockscreener.repository.StockAnalysisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockAnalysisService {
    private final ForumScraper forumScraper;
    private final DeepSeekClient deepSeekClient;
    private final StockAnalysisRepository stockAnalysisRepository;

    @Autowired
    public StockAnalysisService(ForumScraper forumScraper,
                                DeepSeekClient deepSeekClient,
                                StockAnalysisRepository stockAnalysisRepository) {
        this.forumScraper = forumScraper;
        this.deepSeekClient = deepSeekClient;
        this.stockAnalysisRepository = stockAnalysisRepository;
    }

    public StockAnalysis analyzeStock(String ticker) {
        try {
            // Step 1: Fetch data from external websites
            String forumData = forumScraper.fetchForumData(ticker);

            // Step 2: Prepare AI prompt
            String prompt = generateAIPrompt(ticker, forumData);

            // Step 3: Get AI analysis
            String analysis = deepSeekClient.analyze(prompt);

            // Step 4: Store and return results
            return storeAnalysis(ticker, analysis);
        } catch (Exception e) {
            throw new StockAnalysisException("Failed to analyze stock", e);
        }
    }

    private String generateAIPrompt(String ticker, String forumData) {
        return String.format("""
            Analyze this stock data for %s:
            %s
            
            Based on this analysis, should someone buy %s? 
            Provide a detailed analysis including sentiment, trends, and a clear buy/sell recommendation.
            """, ticker, forumData, ticker);
    }

    private StockAnalysis storeAnalysis(String ticker, String analysis) {
        StockAnalysis stockAnalysis = new StockAnalysis();
        stockAnalysis.setTicker(ticker);
        stockAnalysis.setAnalysis(analysis);
        stockAnalysis.setTimestamp(LocalDateTime.now());

        return stockAnalysisRepository.save(stockAnalysis);
    }
}
