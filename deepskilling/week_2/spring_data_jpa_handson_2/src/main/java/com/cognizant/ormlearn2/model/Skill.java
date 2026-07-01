package com.cognizant.ormlearn2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private Integer id;
    @Column(name = "sk_name")
    private String name;
    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList = new HashSet<>();

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
