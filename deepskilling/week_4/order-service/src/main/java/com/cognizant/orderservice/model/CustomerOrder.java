package com.cognizant.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String item;
    private int amount;

    public CustomerOrder() {
    }

    public CustomerOrder(Long id, Long userId, String item, int amount) {
        this.id = id;
        this.userId = userId;
        this.item = item;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
