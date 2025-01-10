package com.example.postService.services;

import com.example.postService.modelDB.Post;
import com.example.postService.modelDTO.PostDTO;
import com.example.postService.modelDTO.PostMapper;
import com.example.postService.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository repository;


    @Override
    public Mono<PostDTO> createPost(PostDTO postDTO){
        log.info("Starting createPost");
        Post post = PostMapper.INSTANCE.toEntity(postDTO);
        return repository.save(post).map(PostMapper.INSTANCE::toDTO);
    }

    @Override
    public Mono<PostDTO> updatePost(Long id, PostDTO postDTO) {
        Post post = PostMapper.INSTANCE.toEntity(postDTO);
        return repository.findById(id)
                .flatMap(existingPost -> {
                    existingPost.setTitle(post.getTitle());
                    existingPost.setContent(post.getContent());
                    return repository.save(existingPost);
                }).map(PostMapper.INSTANCE::toDTO);
    }

    @Override
    public Mono<Void> deletePost(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Flux<PostDTO> getAllPosts() {
        Flux<Post> posts = repository.findAll();
        posts.doOnNext(post -> log.info("Post entity: {}", post))
                .subscribe();
        return repository.findAll().map(PostMapper.INSTANCE::toDTO);
    }
}
