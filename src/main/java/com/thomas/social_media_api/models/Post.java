package com.thomas.social_media_api.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private List<String> tags;
    private String userId;
    private String imageUrl;
    private String videoUrl;
    private int likes;
    private int comments;
    private String createdAt;
    private String updatedAt;
}
