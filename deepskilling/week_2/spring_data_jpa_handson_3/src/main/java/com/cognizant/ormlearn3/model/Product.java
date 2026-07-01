package com.cognizant.ormlearn3.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String operatingSystem;
    private int ramSize;
    private double customerReview;

    public Product() {
    }

    public Product(String name, String operatingSystem, int ramSize, double customerReview) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.ramSize = ramSize;
        this.customerReview = customerReview;
    }
}
