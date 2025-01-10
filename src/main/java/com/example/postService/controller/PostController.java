package com.example.postService.controller;

import com.example.postService.modelDB.Post;
import com.example.postService.modelDTO.PostDTO;
import com.example.postService.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Mono<PostDTO> createPost(@RequestBody PostDTO post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Mono<PostDTO> updatePost(@PathVariable Long id, @RequestBody PostDTO post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @GetMapping
    public Flux<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }
}
