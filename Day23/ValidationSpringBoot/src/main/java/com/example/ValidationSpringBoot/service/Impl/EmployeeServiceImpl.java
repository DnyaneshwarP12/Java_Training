package com.example.ValidationSpringBoot.service.Impl;

import com.example.ValidationSpringBoot.dto.EmployeeDTO;
import com.example.ValidationSpringBoot.entity.Employee;
import com.example.ValidationSpringBoot.exception.ResourceNotFound;
import com.example.ValidationSpringBoot.repository.EmployeeRepository;
import com.example.ValidationSpringBoot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        dto.setEmail(Employee.getEmail());
        dto.setPassword(Employee.getPassword());
        return dto;
    }

    private Employee mapToEntity(EmployeeDTO dto) {
        Employee Employee = new Employee();
        Employee.setName(dto.getName());
        Employee.setDepartment(dto.getDepartment());
        Employee.setEmail(dto.getEmail());
        Employee.setPassword(dto.getPassword());
        return Employee;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO EmployeeDTO) {
        Employee Employee = mapToEntity(EmployeeDTO);
        return mapToDTO(repository.save(Employee));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EmployeeDTO getById(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee not found with id: " + id));

        return mapToDTO(employee);
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee not found with id: " + id));

        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(employeeDTO.getPassword());

        return mapToDTO(repository.save(employee));
    }

    @Override
    public boolean delete(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee not found with id: " + id));

        repository.delete(employee);
        return false;
    }

}
