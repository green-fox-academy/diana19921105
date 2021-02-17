package com.greenfox.springadvanced.repository;

import com.greenfox.springadvanced.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);
}
