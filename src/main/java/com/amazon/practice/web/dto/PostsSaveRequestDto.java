package com.amazon.practice.web.dto;

public record PostsSaveRequestDto(
        String title,
        String content,
        String author
) {
}
