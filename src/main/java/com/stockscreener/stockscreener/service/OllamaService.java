package com.stockscreener.stockscreener.service;

import com.stockscreener.stockscreener.domain.entity.dto.OllamaRequest;
import com.stockscreener.stockscreener.domain.entity.dto.OllamaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {
    private final RestTemplate restTemplate;
    private final String ollamaBaseUrl;
    private final String modelName;

    public OllamaService(RestTemplateBuilder restTemplateBuilder,
                         @Value("${spring.ai.ollama.base-url}") String ollamaBaseUrl,
                         @Value("${spring.ai.ollama.chat.options.model}") String modelName) {
        this.restTemplate = restTemplateBuilder.build();
        this.ollamaBaseUrl = ollamaBaseUrl;
        this.modelName = modelName;
    }

    public String generateResponse(String prompt) {
        try {
            OllamaRequest request = new OllamaRequest(
                    modelName,
                    prompt,
                    false
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            ResponseEntity<OllamaResponse> response = restTemplate.exchange(
                    ollamaBaseUrl + "/api/generate",
                    HttpMethod.POST,
                    new HttpEntity<>(request, headers),
                    OllamaResponse.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody().response() != null
                        ? response.getBody().response()
                        : "Received empty response from model";
            }
            return "Ollama API returned status: " + response.getStatusCode();
        } catch (RestClientException e) {
            throw new RuntimeException("Error communicating with Ollama: " + e.getMessage());
        }
    }
}
