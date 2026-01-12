package com.example.SpringBootJPA.controller;

import com.example.SpringBootJPA.entity.Employee;
import com.example.SpringBootJPA.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


    @GetMapping
    public Page<Employee> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getEmployees(page, size, sortBy);
    }


    @GetMapping("/multi-sort")
    public Page<Employee> getMultiSort(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return employeeService.getEmployeesMultiSort(page, size);
    }
}