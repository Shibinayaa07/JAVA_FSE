package com.cognizant.userservice;

import com.cognizant.userservice.model.AppUser;
import com.cognizant.userservice.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedUsers(AppUserRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new AppUser(null, "Arun", "arun@example.com"));
                repository.save(new AppUser(null, "Meera", "meera@example.com"));
            }
        };
    }
}
