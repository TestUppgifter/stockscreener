package com.stockscreener.stockscreener.domain.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ForumPostDTO {
    private Long id;
    private String content;
    private String userUsername;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Map<String, Object> analysis;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, Object> getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Map<String, Object> analysis) {
        this.analysis = analysis;
    }

    public void setUsername(String username) {
        this.userUsername = username;
    }
}
