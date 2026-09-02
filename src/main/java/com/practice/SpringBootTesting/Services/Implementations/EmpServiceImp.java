package com.practice.SpringBootTesting.Services.Implementations;

import com.practice.SpringBootTesting.DTO.EmployeeDTO;
import com.practice.SpringBootTesting.Entites.Employee;
import com.practice.SpringBootTesting.Exceptions.EmployeeNotFound;
import com.practice.SpringBootTesting.Repositories.EmployeeRepo;
import com.practice.SpringBootTesting.Services.EmpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
public class EmpServiceImp implements EmpService {
    private final EmployeeRepo  empRepo;
    private final ModelMapper mapper;

    @Override
    public EmployeeDTO getEmployee(Long id) {
        log.info("Finding Employee with id : "+ id);
        Employee emp = empRepo.findById(id)
                .orElseThrow(
                        ()->{
                                log.error("Employee Not found with id : "+ id);
                                return new EmployeeNotFound("Employee Not Found with id: " + id);
                        });
        log.info("Found Employee : "+ emp);
        EmployeeDTO empDTO = mapper.map(emp, EmployeeDTO.class);
        return empDTO;

    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Finding Employee with id : "+ id);
        Employee emp = empRepo.findById(id).orElseThrow(
                ()-> {
                    log.error("Employee Not found with id : "+ id);
                    return new EmployeeNotFound("Employee Not Found with id: " + id);
                } );
        log.info("Deleting Employee : "+emp);
        empRepo.delete(emp);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO emp) {
        log.info("Finding Employee with Email : "+ emp.getEmail());
        Optional<Employee> employee = empRepo.findByEmail(emp.getEmail());
        if(employee.isPresent()){
            log.error("Employee already exists with email : "+emp.getEmail());
            throw new RuntimeException("Employee Already Exists with Email : " + emp.getEmail());
        }

        log.info("Creating Employee : "+ emp);
        Employee employee1 = mapper.map(emp, Employee.class);

        employee1 = empRepo.save(employee1);
        log.info("Successfully Employee is created with id : "+ employee1.getId());
        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO emp) {
            log.info("Finding Employee with id : "+ id);
            Employee emp1 = empRepo.findById(id).orElseThrow(
                    () ->{
                        log.error("Employee Not found with id : "+ id);
                        return new EmployeeNotFound("Employee Not Found with id: " + id);
                    }
            );

            log.info("Updating Employee with id: "+id);
            emp.setId(null);
            mapper.map(emp, emp1);
            empRepo.save(emp1);
            log.info("Successfully Employee is updated with id : "+ id);
            return mapper.map(emp1, EmployeeDTO.class);
    }
}
