package com.greenfox.reddit.service;

import com.greenfox.reddit.model.User;
import com.greenfox.reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
      return userRepository.findById(id);
    }

    public Optional<User> findByUserName(String name) {
        return userRepository.findByName(name);
    }
}
