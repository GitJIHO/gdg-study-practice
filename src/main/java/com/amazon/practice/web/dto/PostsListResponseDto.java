package com.amazon.practice.web.dto;

import java.time.LocalDateTime;

public record PostsListResponseDto(
        Long id,
        String title,
        String author,
        LocalDateTime modifiedDate) {
}
