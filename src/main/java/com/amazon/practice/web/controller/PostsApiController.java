package com.amazon.practice.web.controller;

import com.amazon.practice.domain.service.PostsService;
import com.amazon.practice.web.dto.PostsListResponseDto;
import com.amazon.practice.web.dto.PostsOnlyResponseDto;
import com.amazon.practice.web.dto.PostsSaveRequestDto;
import com.amazon.practice.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostsApiController {

    private final PostsService postsService;

    public PostsApiController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsOnlyResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}
