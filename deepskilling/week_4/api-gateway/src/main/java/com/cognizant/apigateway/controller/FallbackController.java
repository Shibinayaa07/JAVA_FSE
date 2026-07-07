package com.cognizant.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FallbackController {
    @GetMapping("/fallback/customers")
    public Map<String, String> customerFallback() {
        return Map.of("message", "Customer service is temporarily unavailable");
    }

    @GetMapping("/fallback/billing")
    public Map<String, String> billingFallback() {
        return Map.of("message", "Billing service is temporarily unavailable");
    }
}
