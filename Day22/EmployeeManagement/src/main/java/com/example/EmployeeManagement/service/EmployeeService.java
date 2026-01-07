package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO EmployeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO EmployeeDTO);
    boolean deleteEmployee(Long id);
}

