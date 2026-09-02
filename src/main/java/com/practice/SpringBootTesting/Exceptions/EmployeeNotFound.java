package com.practice.SpringBootTesting.Exceptions;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super("Employee Not Found");
    }

    public EmployeeNotFound(String message) {
        super(message);
    }
}
