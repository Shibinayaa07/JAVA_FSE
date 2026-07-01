package com.cognizant.ormlearn3.model;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }
}
