package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.client.UserClient;
import com.cognizant.orderservice.model.CustomerOrder;
import com.cognizant.orderservice.repository.CustomerOrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    private final CustomerOrderRepository repository;
    private final UserClient userClient;

    public OrderController(CustomerOrderRepository repository, UserClient userClient) {
        this.repository = repository;
        this.userClient = userClient;
    }

    @GetMapping("/orders")
    public List<CustomerOrder> getOrders() {
        return repository.findAll();
    }

    @GetMapping("/users/{userId}/orders")
    public Map<String, Object> getOrdersByUser(@PathVariable Long userId) {
        return Map.of("user", userClient.getUser(userId), "orders", repository.findByUserId(userId));
    }

    @PostMapping("/orders")
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return repository.save(order);
    }
}
