package com.cognizant.ormlearn3.model;

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
public class AttemptQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Attempt attempt;
    @ManyToOne
    private Question question;
    @OneToMany(mappedBy = "attemptQuestion", cascade = CascadeType.ALL)
    private Set<AttemptOption> attemptOptions = new HashSet<>();
}
