package com.practice.SpringBootTesting.Repositories;

import com.practice.SpringBootTesting.Entites.Employee;
import com.practice.SpringBootTesting.TestConfigs.TestContainersConfigurations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.util.Optional;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestContainersConfigurations.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepoTest {
    static {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }
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
       // assertThat(employee1.get().getEmail()).isBlank().isEmpty();

    }
}