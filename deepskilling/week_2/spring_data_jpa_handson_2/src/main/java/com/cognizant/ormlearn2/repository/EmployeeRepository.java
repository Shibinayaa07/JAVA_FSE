package com.cognizant.ormlearn2.repository;

import com.cognizant.ormlearn2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
