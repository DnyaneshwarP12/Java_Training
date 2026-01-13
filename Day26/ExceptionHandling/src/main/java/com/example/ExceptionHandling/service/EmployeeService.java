package com.example.ExceptionHandling.service;

import com.example.ExceptionHandling.entity.Employee;
import com.example.ExceptionHandling.exception.ResourceNotFound;
import com.example.ExceptionHandling.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee Id not found .."+id));
    }
}
