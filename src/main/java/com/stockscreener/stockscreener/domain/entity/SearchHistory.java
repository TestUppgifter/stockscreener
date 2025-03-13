package com.stockscreener.stockscreener.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String searchQuery;

    @Column(nullable = false)
    private LocalDateTime searchedAt;

    @Column(nullable = false)
    private Integer resultCount;

    @Column(nullable = false)
    private String searchType;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String parameters;
}