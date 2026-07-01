package com.cognizant.ormlearn3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<QuestionOption> options = new HashSet<>();

    public Question() {
    }

    public Question(String text) {
        this.text = text;
    }

    public Set<QuestionOption> getOptions() {
        return options;
    }
}
