package com.stockscreener.stockscreener.controller;

import com.stockscreener.stockscreener.service.OllamaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String prompt) {
        if (prompt == null || prompt.isBlank()) {
            return ResponseEntity.badRequest().body("Prompt cannot be empty");
        }
        String response = ollamaService.generateResponse(prompt);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/analyze")
    public String analyzeStock(String symbol) {
        String prompt = String.format("Analyze the stock market performance of %s", symbol);
        return ollamaService.generateResponse(prompt);
    }
}
