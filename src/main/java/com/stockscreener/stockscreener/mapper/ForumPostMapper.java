package com.stockscreener.stockscreener.mapper;

import com.stockscreener.stockscreener.domain.entity.ForumPost;
import com.stockscreener.stockscreener.domain.entity.dto.ForumPostDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ForumPostMapper {
    ForumPostDTO toDto(ForumPost forumPost);

    List<ForumPostDTO> toDtos(List<ForumPost> forumPosts);
}
