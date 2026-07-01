package com.cognizant.ormlearn2;

import com.cognizant.ormlearn2.model.Country;
import com.cognizant.ormlearn2.model.Department;
import com.cognizant.ormlearn2.model.Employee;
import com.cognizant.ormlearn2.model.Stock;
import com.cognizant.ormlearn2.repository.CountryRepository;
import com.cognizant.ormlearn2.repository.DepartmentRepository;
import com.cognizant.ormlearn2.repository.EmployeeRepository;
import com.cognizant.ormlearn2.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class Handson2Tests {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void queryMethodsWork() {
        countryRepository.save(new Country("ZA", "South Africa"));
        countryRepository.save(new Country("ZM", "Zambia"));
        countryRepository.save(new Country("ZW", "Zimbabwe"));
        assertFalse(countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou").isEmpty());
        assertEquals(2, countryRepository.findByNameStartingWithIgnoreCase("Z").size());

        stockRepository.save(new Stock("FB", LocalDate.of(2019, 9, 3), BigDecimal.TEN, BigDecimal.valueOf(182.39), 9779400L));
        stockRepository.save(new Stock("GOOGL", LocalDate.of(2019, 4, 23), BigDecimal.TEN, BigDecimal.valueOf(1270.59), 1593400L));
        assertEquals(1, stockRepository.findByCodeAndDateBetween("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30)).size());
        assertEquals(1, stockRepository.findByCodeAndCloseGreaterThan("GOOGL", BigDecimal.valueOf(1250)).size());
    }

    @Test
    void payrollMappingsWork() {
        Department department = departmentRepository.save(new Department("IT"));
        employeeRepository.save(new Employee("Alice", 60000, true, department));
        assertFalse(departmentRepository.findById(department.getId()).get().getEmployeeList().isEmpty());
    }
}
