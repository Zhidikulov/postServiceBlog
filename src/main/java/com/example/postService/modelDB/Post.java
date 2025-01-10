package com.example.postService.modelDB;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("posts")
@ToString
public class Post {
    @Id
    private Long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String content;
}
