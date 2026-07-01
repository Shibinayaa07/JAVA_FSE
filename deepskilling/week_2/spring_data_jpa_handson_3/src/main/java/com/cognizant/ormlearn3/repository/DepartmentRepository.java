package com.cognizant.ormlearn3.repository;

import com.cognizant.ormlearn3.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
