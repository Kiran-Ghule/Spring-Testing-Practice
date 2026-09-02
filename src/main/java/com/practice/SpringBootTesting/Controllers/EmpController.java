package com.practice.SpringBootTesting.Controllers;

import com.practice.SpringBootTesting.DTO.EmployeeDTO;
import com.practice.SpringBootTesting.Entites.Employee;
import com.practice.SpringBootTesting.Services.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp")
@RequiredArgsConstructor
public class EmpController {

    private final EmpService empService;

    @PutMapping()
    public ResponseEntity<EmployeeDTO> updateEmp(@RequestBody EmployeeDTO emp) {
        return ResponseEntity.ok(empService.createEmployee(emp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable Long id) {
        return new ResponseEntity<>(empService.getEmployee(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable Long id) {
        empService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmp(@PathVariable Long id, @RequestBody EmployeeDTO emp) {
        return new ResponseEntity<>(empService.updateEmployee(id, emp), HttpStatus.ACCEPTED);
    }


}
