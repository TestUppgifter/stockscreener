package com.stockscreener.stockscreener.controller;

import com.stockscreener.stockscreener.domain.entity.User;
import com.stockscreener.stockscreener.domain.entity.dto.ForumPostDTO;
import com.stockscreener.stockscreener.service.ForumPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Slf4j
public class ForumPostController {

    private final ForumPostService forumPostService;

    @Autowired
    public ForumPostController(ForumPostService forumPostService) {
        this.forumPostService = forumPostService;
    }

    @GetMapping
    public ResponseEntity<List<ForumPostDTO>> getAllForumPosts() {
        return ResponseEntity.ok(forumPostService.getAllForumPosts());
    }

    @PostMapping
    public ResponseEntity<ForumPostDTO> createForumPost(
            @RequestBody ForumPostDTO request,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(forumPostService.createForumPost(request, user.getUsername()));
    }
}
