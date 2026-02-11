package com.empapp.api.controller;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.api.exception.ResourceNotFoundException;
import com.empapp.api.request.EmployeeDto;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final List<EmployeeDto> employees = List.of(
            new EmployeeDto(1L, "Raj", new BigDecimal("55000.50")),
            new EmployeeDto(2L, "Amit", new BigDecimal("62000.00")),
            new EmployeeDto(3L, "Neha", new BigDecimal("71000.75"))
    );

    // Get all employees
    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employees;
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return employees.stream()
                .filter(emp -> emp.id().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));
    }
}