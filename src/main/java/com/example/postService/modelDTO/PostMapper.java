package com.example.postService.modelDTO;

import com.example.postService.modelDB.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDTO toDTO(Post post);
    Post toEntity(PostDTO postDTO);
}
