package com.cognizant.ormlearn3.model;

import javax.persistence.*;

@Entity
public class AttemptOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean selected;
    @ManyToOne
    private AttemptQuestion attemptQuestion;
    @ManyToOne
    private QuestionOption option;
}
