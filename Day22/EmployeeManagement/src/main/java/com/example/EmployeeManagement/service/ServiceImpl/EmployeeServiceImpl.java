package com.example.EmployeeManagement.service.ServiceImpl;

import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.exception.ResourceNotFound;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    private EmployeeDTO mapToDTO(Employee Employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(Employee.getId());
        dto.setName(Employee.getName());
        dto.setDepartment(Employee.getDepartment());
        dto.setSalary(Employee.getSalary());
        return dto;
    }

    private Employee mapToEntity(EmployeeDTO dto) {
        Employee Employee = new Employee();
        Employee.setName(dto.getName());
        Employee.setDepartment(dto.getDepartment());
        Employee.setSalary(dto.getSalary());
        return Employee;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO EmployeeDTO) {
        Employee Employee = mapToEntity(EmployeeDTO);
        return mapToDTO(repository.save(Employee));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee not found with id: " + id));

        return mapToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee not found with id: " + id));

        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());

        return mapToDTO(repository.save(employee));
    }

    @Override
    public boolean deleteEmployee(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee not found with id: " + id));

        repository.delete(employee);
        return false;
    }

}

