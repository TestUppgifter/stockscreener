package com.stockscreener.stockscreener.repository;

import com.stockscreener.stockscreener.domain.entity.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
    List<ForumPost> findByTicker(String ticker);
}
