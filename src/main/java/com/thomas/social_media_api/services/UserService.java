package com.thomas.social_media_api.services;

import com.thomas.social_media_api.models.User;
import com.thomas.social_media_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUsernameOrEmail(String username, String email) {
        return userRepository.existsByUsernameOrEmail(username, email);
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    private User createPost(User user) {
        return userRepository.save(user);
    }

    private User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private User updateUser(String id, User user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setAvatar(user.getAvatar());
        userToUpdate.setBio(user.getBio());
        userToUpdate.setLocation(user.getLocation());
        userToUpdate.setWebsite(user.getWebsite());
        return userRepository.save(userToUpdate);
    }

    private void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
