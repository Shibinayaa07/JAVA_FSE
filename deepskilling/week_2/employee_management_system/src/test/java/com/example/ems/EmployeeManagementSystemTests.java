package com.example.ems;

import com.example.ems.entity.Department;
import com.example.ems.entity.Employee;
import com.example.ems.repository.DepartmentRepository;
import com.example.ems.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeManagementSystemTests {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void employeeRepositoryFeaturesWork() {
        Department department = departmentRepository.save(new Department("IT"));
        Employee employee = employeeRepository.save(new Employee("John", "john@example.com", 70000, department));
        assertEquals(1, employeeRepository.findByDepartmentName("IT").size());
        assertEquals("John", employeeRepository.findByEmailNamed("john@example.com").getName());
        assertFalse(employeeRepository.findEmployeesWithSalaryAtLeast(50000).isEmpty());
        assertFalse(employeeRepository.findBySalaryGreaterThan(50000).isEmpty());
        assertFalse(employeeRepository.getEmployeeSummaries().isEmpty());
        assertEquals(1, employeeRepository.findByDepartmentName("IT", PageRequest.of(0, 5)).getTotalElements());
        assertNotNull(employee.getCreatedDate());
    }
}
