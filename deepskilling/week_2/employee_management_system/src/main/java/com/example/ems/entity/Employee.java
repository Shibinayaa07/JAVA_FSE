package com.example.ems.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@NamedQuery(name = "Employee.findByEmailNamed", query = "SELECT e FROM Employee e WHERE e.email = ?1")
public class Employee extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private double salary;
    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(String name, String email, double salary, Department department) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
