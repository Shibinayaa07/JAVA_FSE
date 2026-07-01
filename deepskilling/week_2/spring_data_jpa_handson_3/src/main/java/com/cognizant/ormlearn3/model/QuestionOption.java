package com.cognizant.ormlearn3.model;

import jakarta.persistence.*;

@Entity
public class QuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String optionText;
    private double score;
    private boolean correctAnswer;
    @ManyToOne
    private Question question;

    public QuestionOption() {
    }
}
