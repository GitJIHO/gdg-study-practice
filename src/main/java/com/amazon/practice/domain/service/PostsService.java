package com.amazon.practice.domain.service;

import com.amazon.practice.domain.posts.Posts;
import com.amazon.practice.domain.posts.PostsRepository;
import com.amazon.practice.web.dto.PostsListResponseDto;
import com.amazon.practice.web.dto.PostsOnlyResponseDto;
import com.amazon.practice.web.dto.PostsSaveRequestDto;
import com.amazon.practice.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        Posts posts = new Posts(requestDto.title(), requestDto.content(), requestDto.author());
        postsRepository.save(posts);
        return posts.getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.title(), requestDto.content());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsOnlyResponseDto findById(Long id) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsOnlyResponseDto(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(post -> new PostsListResponseDto(
                        post.getId(),
                        post.getTitle(),
                        post.getAuthor(),
                        post.getModifiedDate()))
                .collect(Collectors.toList());
    }
}
