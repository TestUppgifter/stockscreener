package com.stockscreener.stockscreener.controller;

import com.stockscreener.stockscreener.domain.entity.SearchHistory;
import com.stockscreener.stockscreener.service.SearchHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-history")
@Slf4j
public class SearchHistoryController {

    private final SearchHistoryService searchHistoryService;

    @Autowired
    public SearchHistoryController(SearchHistoryService searchHistoryService) {
        this.searchHistoryService = searchHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<SearchHistory>> getAllSearchHistory() {
        return ResponseEntity.ok(searchHistoryService.getAllSearchHistory());
    }

    @PostMapping
    public ResponseEntity<SearchHistory> createSearchHistory(
            @RequestBody SearchHistory searchHistory) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(searchHistoryService.createSearchHistory(searchHistory));
    }

    @GetMapping("/by-type/{searchType}")
    public ResponseEntity<List<SearchHistory>> searchHistoryByType(
            @PathVariable String searchType) {
        return ResponseEntity.ok(searchHistoryService.searchHistoryByType(searchType));
    }
}
