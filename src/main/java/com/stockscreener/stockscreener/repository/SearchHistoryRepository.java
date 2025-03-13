package com.stockscreener.stockscreener.repository;

import com.stockscreener.stockscreener.domain.entity.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    List<SearchHistory> findBySearchType(String searchType);
    List<SearchHistory> findByStatus(String status);
}
