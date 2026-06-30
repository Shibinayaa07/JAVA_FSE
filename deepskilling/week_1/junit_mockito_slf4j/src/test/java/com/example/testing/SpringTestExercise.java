package com.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringTestExercise.TestConfig.class)
class SpringTestExercise {
    @Autowired
    private UserService userService;

    @Test
    void testSpringContextLoadsService() {
        assertEquals("Hello Rahul", userService.getGreeting(1));
    }

    @Configuration
    static class TestConfig {
        @Bean
        UserRepository userRepository() {
            return id -> id == 1 ? "Rahul" : "Guest";
        }

        @Bean
        UserService userService(UserRepository userRepository) {
            return new UserService(userRepository);
        }
    }
}
