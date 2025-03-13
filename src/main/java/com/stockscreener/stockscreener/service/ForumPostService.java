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
@Slf4j
public class ForumPostService {

    private final ForumPostRepository forumPostRepository;
    private final UserRepository userRepository;

    @Autowired
    public ForumPostService(ForumPostRepository forumPostRepository,
                            UserRepository userRepository) {
        this.forumPostRepository = forumPostRepository;
        this.userRepository = userRepository;
    }

    public List<ForumPostDTO> getAllForumPosts() {
        return forumPostRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ForumPostDTO createForumPost(ForumPostDTO request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        ForumPost post = new ForumPost();
        post.setUser(user);
        post.setContent(request.getContent());

        ForumPost savedPost = forumPostRepository.save(post);
        return convertToDTO(savedPost);
    }

    private ForumPostDTO convertToDTO(ForumPost post) {
        ForumPostDTO dto = new ForumPostDTO();
        dto.setContent(post.getContent());
        dto.setUsername(post.getUser().getUsername());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        return dto;
    }
}