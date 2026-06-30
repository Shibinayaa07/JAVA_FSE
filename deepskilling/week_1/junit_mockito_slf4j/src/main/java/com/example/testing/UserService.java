package com.example.testing;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getGreeting(int userId) {
        return "Hello " + userRepository.findNameById(userId);
    }
}
