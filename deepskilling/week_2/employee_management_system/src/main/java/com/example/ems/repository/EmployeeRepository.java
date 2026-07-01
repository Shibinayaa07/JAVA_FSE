package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeNameView;
import com.example.ems.projection.EmployeeSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findByNameContainingIgnoreCase(String text);
    Employee findByEmailNamed(String email);
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.salary >= ?1")
    List<Employee> findEmployeesWithSalaryAtLeast(double salary);

    List<EmployeeNameView> findBySalaryGreaterThan(double salary);

    @Query("SELECT new com.example.ems.projection.EmployeeSummary(e.name, e.department.name) FROM Employee e")
    List<EmployeeSummary> getEmployeeSummaries();
}
