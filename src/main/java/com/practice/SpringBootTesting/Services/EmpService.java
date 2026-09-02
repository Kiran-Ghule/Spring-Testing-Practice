package com.practice.SpringBootTesting.Services;

import com.practice.SpringBootTesting.DTO.EmployeeDTO;
import com.practice.SpringBootTesting.Entites.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {

    public EmployeeDTO getEmployee(Long id);
    public void deleteEmployee(Long id);
    public EmployeeDTO createEmployee(EmployeeDTO emp);
    public EmployeeDTO updateEmployee(Long id,EmployeeDTO emp);
}
