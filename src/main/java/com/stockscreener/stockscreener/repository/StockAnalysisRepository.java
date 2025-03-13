package com.stockscreener.stockscreener.repository;

import com.stockscreener.stockscreener.domain.entity.StockAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockAnalysisRepository extends JpaRepository<StockAnalysis, Long> {
}
