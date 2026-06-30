package com.example.testing;

public class OrderService {
    private final InventoryRepository inventoryRepository;
    private final PaymentGateway paymentGateway;

    public OrderService(InventoryRepository inventoryRepository, PaymentGateway paymentGateway) {
        this.inventoryRepository = inventoryRepository;
        this.paymentGateway = paymentGateway;
    }

    public boolean placeOrder(String productId, int quantity, double amount) {
        if (!inventoryRepository.isAvailable(productId, quantity)) {
            return false;
        }
        if (!paymentGateway.pay(amount)) {
            return false;
        }
        inventoryRepository.reduceStock(productId, quantity);
        return true;
    }
}
