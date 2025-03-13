package com.stockscreener.stockscreener.service;

import com.stockscreener.stockscreener.domain.entity.SearchHistory;
import com.stockscreener.stockscreener.repository.SearchHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;

    @Autowired
    public SearchHistoryService(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    public List<SearchHistory> getAllSearchHistory() {
        return searchHistoryRepository.findAll();
    }

    public SearchHistory createSearchHistory(SearchHistory searchHistory) {
        return searchHistoryRepository.save(searchHistory);
    }

    public List<SearchHistory> searchHistoryByType(String searchType) {
        return searchHistoryRepository.findBySearchType(searchType);
    }
}
