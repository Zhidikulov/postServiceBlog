package com.example.postService.services;

import com.example.postService.modelDB.Post;
import com.example.postService.modelDTO.PostDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Mono<PostDTO> createPost(PostDTO postDTO);
    Mono<PostDTO> updatePost(Long id, PostDTO post);
    Mono<Void> deletePost(Long id);
    Flux<PostDTO> getAllPosts();
}
