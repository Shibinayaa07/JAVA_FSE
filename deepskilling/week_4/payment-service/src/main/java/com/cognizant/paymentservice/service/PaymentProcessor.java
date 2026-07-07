package com.cognizant.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProcessor.class);

    @CircuitBreaker(name = "paymentGateway", fallbackMethod = "fallbackPayment")
    public Map<String, Object> process(long id) {
        if (id % 2 == 0) {
            throw new IllegalStateException("Third-party payment API is slow");
        }
        return Map.of("paymentId", id, "status", "SUCCESS");
    }

    public Map<String, Object> fallbackPayment(long id, Throwable throwable) {
        LOGGER.warn("Payment fallback triggered for {} because {}", id, throwable.getMessage());
        return Map.of("paymentId", id, "status", "PENDING_RETRY", "reason", "fallback");
    }
}
