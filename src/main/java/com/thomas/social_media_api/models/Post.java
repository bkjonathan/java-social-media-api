package com.thomas.social_media_api.models;

import org.springframework.data.annotation.Id;

import java.util.List;

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
