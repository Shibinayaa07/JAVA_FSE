package com.cognizant.ormlearn3.repository;

import com.cognizant.ormlearn3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
