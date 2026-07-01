package com.cognizant.ormlearn3.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private QuizUser user;
    private LocalDate attemptedDate;
    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL)
    private Set<AttemptQuestion> attemptQuestions = new HashSet<>();

    public Attempt() {
    }

    public Attempt(QuizUser user, LocalDate attemptedDate) {
        this.user = user;
        this.attemptedDate = attemptedDate;
    }

    public Integer getId() {
        return id;
    }
}
