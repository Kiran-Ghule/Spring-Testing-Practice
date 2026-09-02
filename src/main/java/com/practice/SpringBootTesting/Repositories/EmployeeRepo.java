package com.practice.SpringBootTesting.Repositories;

import com.practice.SpringBootTesting.Entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
