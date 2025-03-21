package com.stockscreener.stockscreener.service;

import com.stockscreener.stockscreener.domain.entity.ForumPost;
import com.stockscreener.stockscreener.domain.entity.User;
import com.stockscreener.stockscreener.domain.entity.dto.ForumPostDTO;
import com.stockscreener.stockscreener.repository.ForumPostRepository;
import com.stockscreener.stockscreener.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumPostService {
    private final ForumPostRepository forumPostRepository;

    @Autowired
    public ForumPostService(ForumPostRepository forumPostRepository) {
        this.forumPostRepository = forumPostRepository;
    }

    public List<ForumPostDTO> getAllForumPosts() {
        return forumPostRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ForumPostDTO createForumPost(ForumPostDTO request) {
        ForumPost post = new ForumPost();
        post.setContent(request.getContent());
        post.setTicker(request.getTicker());

        ForumPost savedPost = forumPostRepository.save(post);
        return convertToDTO(savedPost);
    }

    private ForumPostDTO convertToDTO(ForumPost post) {
        ForumPostDTO dto = new ForumPostDTO();
        dto.setContent(post.getContent());
        dto.setTicker(post.getTicker());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        return dto;
    }
}