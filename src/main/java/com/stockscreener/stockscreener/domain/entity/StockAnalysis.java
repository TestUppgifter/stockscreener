package com.stockscreener.stockscreener.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_analysis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ticker;

    @Column(columnDefinition = "TEXT")
    private String analysis;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void setTicker(String ticker) {
        this.ticker = ticker;;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public void setTimestamp(LocalDateTime now) {
        this.timestamp = now;
    }
}

