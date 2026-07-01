package com.cognizant.ormlearn2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private Integer id;
    @Column(name = "em_name")
    private String name;
    @Column(name = "em_salary")
    private double salary;
    @Column(name = "em_permanent")
    private boolean permanent;
    @Column(name = "em_date_of_birth")
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "em_dp_id")
    private Department department;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_skill", joinColumns = @JoinColumn(name = "es_em_id"), inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
    private Set<Skill> skillList = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, double salary, boolean permanent, Department department) {
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.department = department;
        this.dateOfBirth = new Date();
    }

    public Integer getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public Set<Skill> getSkillList() {
        return skillList;
    }
}
