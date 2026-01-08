package com.example.ValidationSpringBoot.service;

import com.example.ValidationSpringBoot.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployee ();
    EmployeeDTO update(Long id, EmployeeDTO employeeDTO);
    boolean delete(Long id);
    EmployeeDTO getById(Long id);



}
