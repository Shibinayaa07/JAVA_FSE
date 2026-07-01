package com.cognizant.ormlearn2.repository;

import com.cognizant.ormlearn2.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
