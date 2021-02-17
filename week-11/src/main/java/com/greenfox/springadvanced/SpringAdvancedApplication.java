package com.greenfox.springadvanced;

import com.greenfox.springadvanced.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

}
