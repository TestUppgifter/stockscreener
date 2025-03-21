package com.stockscreener.stockscreener.component;

import com.stockscreener.stockscreener.exception.DeepSeekException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class DeepSeekClient {
    private final String aiUrl;

    public DeepSeekClient(@Value("${AI_URL:http://ai:8081}") String aiUrl) {
        this.aiUrl = aiUrl;
    }

    public String analyze(String prompt) {
        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl(aiUrl)
                    .build();

            return webClient.post()
                    .bodyValue(prompt)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new DeepSeekException("Failed to analyze text", e);
        }
    }
}
