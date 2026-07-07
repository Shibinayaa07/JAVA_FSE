package com.cognizant.productservice.controller;

import com.cognizant.productservice.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final String currency;

    public ProductController(@Value("${catalog.currency:INR}") String currency) {
        this.currency = currency;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return List.of(new Product(1L, "Laptop", 25, currency), new Product(2L, "Mouse", 8, currency));
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return getProducts().stream().filter(product -> product.id().equals(id)).findFirst().orElseThrow();
    }
}
