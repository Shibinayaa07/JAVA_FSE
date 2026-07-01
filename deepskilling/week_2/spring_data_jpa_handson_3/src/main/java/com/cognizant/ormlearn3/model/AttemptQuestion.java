package com.cognizant.ormlearn3.model;

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
