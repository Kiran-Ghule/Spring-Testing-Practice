package com.practice.SpringBootTesting.Repositories;

import com.practice.SpringBootTesting.Entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
