package com.amazon.practice.web.dto;

import com.amazon.practice.domain.posts.Posts;

public record PostsOnlyResponseDto(
        Posts posts
) {
}
