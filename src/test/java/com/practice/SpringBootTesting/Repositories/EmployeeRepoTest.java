package com.practice.SpringBootTesting.Repositories;

import com.practice.SpringBootTesting.Entites.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepoTest {
    @Autowired
    private EmployeeRepo employeeRepo;

    private Employee employee;

    @Test
    void findEmployee_IFValidEmail_ByEmail() {

    }
}