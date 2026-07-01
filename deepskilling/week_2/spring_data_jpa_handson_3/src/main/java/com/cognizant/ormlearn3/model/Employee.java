package com.cognizant.ormlearn3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double salary;
    private boolean permanent;
    @ManyToOne
    private Department department;
    @ManyToMany
    private Set<Skill> skillList = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, double salary, boolean permanent, Department department) {
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.department = department;
    }

    public Set<Skill> getSkillList() {
        return skillList;
    }
}
