package com.cognizant.ormlearn3;

import com.cognizant.ormlearn3.model.Department;
import com.cognizant.ormlearn3.model.Employee;
import com.cognizant.ormlearn3.model.Product;
import com.cognizant.ormlearn3.repository.DepartmentRepository;
import com.cognizant.ormlearn3.repository.EmployeeRepository;
import com.cognizant.ormlearn3.repository.ProductRepository;
import com.cognizant.ormlearn3.service.EmployeeService;
import com.cognizant.ormlearn3.service.ProductCriteriaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class Handson3Tests {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCriteriaService productCriteriaService;

    @Test
    void hqlAndNativeQueriesWork() {
        Department department = departmentRepository.save(new Department("IT"));
        employeeRepository.save(new Employee("Asha", 50000, true, department));
        employeeRepository.save(new Employee("Ravi", 30000, false, department));
        assertEquals(1, employeeService.getAllPermanentEmployees().size());
        assertEquals(40000.0, employeeService.getAverageSalary(department.getId()));
        assertEquals(2, employeeService.getAllEmployeesNative().size());
    }

    @Test
    void criteriaQueryWorks() {
        productRepository.save(new Product("Laptop Pro", "Windows", 16, 4.5));
        assertFalse(productCriteriaService.search("laptop", "Windows", 16, 4.0).isEmpty());
    }
}
