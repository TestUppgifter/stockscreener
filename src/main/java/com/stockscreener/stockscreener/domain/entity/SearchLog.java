package com.stockscreener.stockscreener.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "search_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "search_history_id")
    private SearchHistory searchHistory;

    @Column(columnDefinition = "JSON", nullable = false)
    private String logDetails;

}
