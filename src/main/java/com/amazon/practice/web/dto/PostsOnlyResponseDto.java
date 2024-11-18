package com.amazon.practice.web.dto;

import com.amazon.practice.domain.posts.Posts;

public class PostsOnlyResponseDto {
    private final Posts posts;

    public PostsOnlyResponseDto(Posts posts) {
        this.posts = posts;
    }

    public Long getId() {
        return posts.getId();
    }

    public String getTitle() {
        return posts.getTitle();
    }

    public String getContent() {
        return posts.getContent();
    }

    public String getAuthor() {
        return posts.getAuthor();
    }
}
