package com.cognizant.ormlearn3.model;

import javax.persistence.*;

@Entity
public class QuizUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    public QuizUser() {
    }

    public QuizUser(String username) {
        this.username = username;
    }
}
