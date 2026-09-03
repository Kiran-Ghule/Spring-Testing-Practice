package com.practice.SpringBootTesting.Repositories;

import com.practice.SpringBootTesting.Entites.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepoTest {
    @Autowired
    private EmployeeRepo employeeRepo;

    private Employee employee;

    @BeforeEach
    public void setup() {
        employee = new Employee(null, "Samay","samayara@gmail.com",10000L);
    }

    @Test
    void findEmployee_IFValidEmail_ByEmail() {
            employeeRepo.save(employee);
           Optional<Employee> employee1= employeeRepo.findByEmail(employee.getEmail());

           assertThat(employee1.get().getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    void findEmployee_IFInvalidEmail_ByEmail() {
        employeeRepo.save(employee);

        Optional<Employee> employee1= employeeRepo.findByEmail(employee.getEmail()+"edu.in");
        assertThat(employee1.get().getEmail()).isBlank().isEmpty();

    }
}