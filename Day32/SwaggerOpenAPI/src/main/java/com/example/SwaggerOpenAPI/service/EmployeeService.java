package com.example.SwaggerOpenAPI.service;

import com.example.SwaggerOpenAPI.entity.Employee;
import com.example.SwaggerOpenAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
