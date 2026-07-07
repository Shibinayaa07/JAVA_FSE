package com.cognizant.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user-service.url:http://localhost:8091}")
public interface UserClient {
    @GetMapping("/users/{id}")
    UserResponse getUser(@PathVariable Long id);

    record UserResponse(Long id, String name, String email) {
    }
}
