package com.thomas.social_media_api.controller;


import com.thomas.social_media_api.models.Post;
import com.thomas.social_media_api.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestParam String title, @RequestParam String content, @RequestParam List<String> tags) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTags(tags);
        post.setCreatedAt(java.time.LocalDateTime.now());
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable String id, @RequestParam String title, @RequestParam String content, @RequestParam List<String> tags) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTags(tags);
        return postService.updatePost(id, title, content, tags);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable String id) {
        postService.deletePost(id);
    }

    @GetMapping("/seed")
    public void seed() {

        for (int i = 1; i <= 50; i++) {
            Post post = new Post();
            post.setTitle("Post " + i);
            post.setContent("This is post number " + i);
            post.setTags(List.of("post", "number" + i));
            post.setCreatedAt(java.time.LocalDateTime.now());
            postService.createPost(post);
        }

//        Post post = new Post();
//        post.setTitle("First Post");
//        post.setContent("This is the first post");
//        post.setTags(List.of("first", "post"));
//        post.setCreatedAt(java.time.LocalDateTime.now());
//        postService.createPost(post);
    }
}
