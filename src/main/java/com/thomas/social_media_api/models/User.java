package com.thomas.social_media_api.models;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String bio;
    private String location;
    private String website;
    private String createdAt;
    private String updatedAt;
}
