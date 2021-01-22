package com.greenfox.reddit.service;

import com.greenfox.reddit.model.Post;
import com.greenfox.reddit.model.User;
import com.greenfox.reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void findByIdAndAddPost(Long id) {
        Optional<User> findById = userRepository.findById(id);
        if (findById.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            User uploadingUser = findById.get();
            List<Post> posts = uploadingUser.getPost();
            posts.add(new Post());
        }
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void findById(Long id) {
        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) {
            userRepository.save(new User());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void findByUserName(String name) {
        Optional<User> byUserName = userRepository.findByName(name);
        if (byUserName.isEmpty()) {
            userRepository.save(User.builder().name(name).build());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
