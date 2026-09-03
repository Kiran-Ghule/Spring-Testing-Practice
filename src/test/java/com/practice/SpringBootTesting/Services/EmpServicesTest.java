package com.practice.SpringBootTesting.Services;

import com.practice.SpringBootTesting.DTO.EmployeeDTO;
import com.practice.SpringBootTesting.Entites.Employee;
import com.practice.SpringBootTesting.Repositories.EmployeeRepo;
import com.practice.SpringBootTesting.Services.Implementations.EmpServiceImp;
import com.practice.SpringBootTesting.TestConfigs.TestContainersConfigurations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestContainersConfigurations.class)
@ExtendWith(MockitoExtension.class)
public class EmpServicesTest {

    @Mock
    EmployeeRepo employeeRepo;

    @Spy
    ModelMapper modelMapper;

    @InjectMocks
    EmpServiceImp empServiceImp;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(1L,"samaraj","sam@gmail.com",20000L);
    }

    @Test
    public void testEmpServices(){

        when(employeeRepo.findById(employee.getId())).thenReturn(Optional.of(employee));
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        assertThat(empServiceImp.getEmployee(1L)).isEqualTo(employeeDTO);

        verify(employeeRepo,only()).findById(1L);
    }
}
