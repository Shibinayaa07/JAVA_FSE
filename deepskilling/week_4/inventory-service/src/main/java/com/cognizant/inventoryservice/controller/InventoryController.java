package com.cognizant.inventoryservice.controller;

import com.cognizant.inventoryservice.client.ProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InventoryController {
    private final ProductClient productClient;
    private final String message;

    public InventoryController(ProductClient productClient, @Value("${inventory.message:Inventory ready}") String message) {
        this.productClient = productClient;
        this.message = message;
    }

    @GetMapping("/inventory/{productId}")
    public Map<String, Object> getInventory(@PathVariable Long productId) {
        ProductClient.ProductResponse product = productClient.getProduct(productId);
        return Map.of("message", message, "productId", product.id(), "productName", product.name(), "availableStock", product.stock());
    }
}
