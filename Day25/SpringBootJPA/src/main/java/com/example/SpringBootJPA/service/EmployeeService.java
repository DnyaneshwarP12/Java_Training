package com.example.SpringBootJPA.service;

import com.example.SpringBootJPA.entity.Employee;
import org.springframework.data.domain.Page;



public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Page<Employee> getEmployees(int page, int size, String sortBy);
    Page<Employee> getEmployeesMultiSort(int page, int size);
}