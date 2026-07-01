package com.cognizant.ormlearn3.service;

import com.cognizant.ormlearn3.model.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCriteriaService {
    private final EntityManager entityManager;

    public ProductCriteriaService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> search(String keyword, String operatingSystem, Integer ramSize, Double minReview) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if (keyword != null) {
            predicates.add(builder.like(builder.lower(root.get("name")), "%" + keyword.toLowerCase() + "%"));
        }
        if (operatingSystem != null) {
            predicates.add(builder.equal(root.get("operatingSystem"), operatingSystem));
        }
        if (ramSize != null) {
            predicates.add(builder.equal(root.get("ramSize"), ramSize));
        }
        if (minReview != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("customerReview"), minReview));
        }
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
