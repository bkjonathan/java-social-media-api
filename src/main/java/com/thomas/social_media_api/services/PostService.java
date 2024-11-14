package com.thomas.social_media_api.services;

import com.thomas.social_media_api.models.Post;
import com.thomas.social_media_api.models.User;
import com.thomas.social_media_api.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private Post createPost(Post post) {
        User createdBy = User.builder().id("1").username("thomas").build();
        post.setCreatedBy(createdBy);
        return postRepository.save(post);
    }

    private List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    private Post getPostById(String id) {
        return postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found"));
    }

    private Post updatePost(String id,String title, String content,List<String>tags, Post post) {
        Post postToUpdate = getPostById(id);
        postToUpdate.setTitle(title);
        postToUpdate.setContent(content);
        postToUpdate.setTags(tags);
        return postRepository.save(postToUpdate);
    }

    private void deletePost(String id) {
        postRepository.deleteById(id);
    }
}
