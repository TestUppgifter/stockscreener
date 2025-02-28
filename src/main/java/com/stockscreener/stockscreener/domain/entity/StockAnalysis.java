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

    @ManyToOne
    @JoinColumn(name = "forum_post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ForumPost forumPost;

    @Column(columnDefinition = "JSON", nullable = false)
    private String analysis;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}

