package com.cognizant.userservice.controller;

import com.cognizant.userservice.model.AppUser;
import com.cognizant.userservice.repository.AppUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final AppUserRepository repository;

    public UserController(AppUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public AppUser getUser(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser user) {
        return repository.save(user);
    }
}
