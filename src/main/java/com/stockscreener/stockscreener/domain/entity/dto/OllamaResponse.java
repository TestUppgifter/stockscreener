package com.stockscreener.stockscreener.domain.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OllamaResponse(
        String model,
        String response,
        String created_at,
        boolean done
) {}
