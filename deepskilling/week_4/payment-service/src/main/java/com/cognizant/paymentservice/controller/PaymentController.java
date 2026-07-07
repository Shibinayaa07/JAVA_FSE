package com.cognizant.paymentservice.controller;

import com.cognizant.paymentservice.service.PaymentProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PaymentController {
    private final PaymentProcessor paymentProcessor;

    public PaymentController(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @GetMapping("/payments/{id}")
    public Map<String, Object> processPayment(@PathVariable long id) {
        return paymentProcessor.process(id);
    }
}
