package com.practice.SpringBootTesting.Services.Implementations;

import com.practice.SpringBootTesting.DTO.EmployeeDTO;
import com.practice.SpringBootTesting.Entites.Employee;
import com.practice.SpringBootTesting.Exceptions.EmployeeNotFound;
import com.practice.SpringBootTesting.Repositories.EmployeeRepo;
import com.practice.SpringBootTesting.Services.EmpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

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

    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO emp) {
        return null;
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO emp) {
        return null;
    }
}
