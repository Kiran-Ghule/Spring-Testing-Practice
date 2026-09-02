package com.practice.SpringBootTesting.Services.Implementations;

import com.practice.SpringBootTesting.DTO.EmployeeDTO;
import com.practice.SpringBootTesting.Entites.Employee;
import com.practice.SpringBootTesting.Exceptions.EmployeeNotFound;
import com.practice.SpringBootTesting.Repositories.EmployeeRepo;
import com.practice.SpringBootTesting.Services.EmpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class EmpServiceImp implements EmpService {
    private final EmployeeRepo  empRepo;
    private final ModelMapper mapper;

    @Override
    public EmployeeDTO getEmployee(Long id) {
        Employee emp = empRepo.findById(id)
                .orElseThrow(
                        ()-> new EmployeeNotFound("Employee Not Found with id: " + id));
        EmployeeDTO empDTO = mapper.map(emp, EmployeeDTO.class);
        return empDTO;

    }

    @Override
    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO emp) {
        Employee employee = mapper.map(emp, Employee.class);
        employee = empRepo.save(employee);
        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO emp) {

            Employee employee1 = mapper.map(emp, Employee.class);
            employee1.setId(id);
            employee1=empRepo.save(employee1);
            return mapper.map(employee1, EmployeeDTO.class);
    }
}
