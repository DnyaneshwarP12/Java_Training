package com.example.EmployeesManagement.service;

import com.example.EmployeesManagement.dto.AddressDTO;
import com.example.EmployeesManagement.dto.DepartmentDTO;
import com.example.EmployeesManagement.dto.EmployeeDTO;
import com.example.EmployeesManagement.dto.ProjectDTO;
import com.example.EmployeesManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {


    Employee update(Long id, EmployeeDTO employeeDTO, DepartmentDTO departmentDTO, AddressDTO addressDTO, ProjectDTO projectDTO);

    Employee save(EmployeeDTO employeeDTO);
    Employee getById(Long id);
    List<Employee> getAll();
    Employee update(Long id, EmployeeDTO employeeDTO);
    void delete(Long id);
}
