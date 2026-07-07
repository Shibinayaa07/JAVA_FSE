package com.cognizant.billingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BillingController {
    @GetMapping("/bills/{id}")
    public Map<String, Object> getBill(@PathVariable long id) {
        return Map.of("id", id, "amount", 1299, "status", "PAID");
    }
}
