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
}
