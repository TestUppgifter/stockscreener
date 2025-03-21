package com.stockscreener.stockscreener.service;

import com.stockscreener.stockscreener.exception.ForumScrapingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class ForumScraper {
    private final WebClient webClient;
    private final String forumUrl;

    public ForumScraper(@Value("${FORUM_URL:http://example.com/forums}") String forumUrl) {
        this.forumUrl = forumUrl;
        this.webClient = WebClient.builder()
                .baseUrl(forumUrl)
                .build();
    }

    public String fetchForumData(String ticker) {
        try {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/posts")
                            .queryParam("symbol", ticker)
                            .build())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new ForumScrapingException("Failed to fetch forum data", e);
        }
    }
}