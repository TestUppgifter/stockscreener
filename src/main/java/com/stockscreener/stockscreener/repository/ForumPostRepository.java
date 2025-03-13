package com.stockscreener.stockscreener.repository;

import com.stockscreener.stockscreener.domain.entity.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
}
