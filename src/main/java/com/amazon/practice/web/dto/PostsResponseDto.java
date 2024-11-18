package com.amazon.practice.web.dto;

public record PostsResponseDto(
        Long id,
        String title,
        String content,
        String author
) {

}

