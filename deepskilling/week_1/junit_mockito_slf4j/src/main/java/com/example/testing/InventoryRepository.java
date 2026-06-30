package com.example.testing;

public interface InventoryRepository {
    boolean isAvailable(String productId, int quantity);

    void reduceStock(String productId, int quantity);
}
