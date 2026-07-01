package com.cognizant.ormlearn3.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
