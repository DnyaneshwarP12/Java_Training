package com.example.SpringBootJPA.service.Impl;

import com.example.SpringBootJPA.entity.Employee;
import com.example.SpringBootJPA.exception.ResourceNotFoundException;
import com.example.SpringBootJPA.repository.EmployeeJpaRepository;
import com.example.SpringBootJPA.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeJpaRepository jpaRepository;


    public EmployeeServiceImpl(EmployeeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public Employee createEmployee(Employee employee) {
        return jpaRepository.save(employee);
    }


    @Override
    public Employee getEmployeeById(Long id) {
        return jpaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
    }


    @Override
    public Page<Employee> getEmployees(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return jpaRepository.findAll(pageable);
    }


    @Override
    public Page<Employee> getEmployeesMultiSort(int page, int size) {
        Sort sort = Sort.by("department").ascending()
                .and(Sort.by("salary").descending());
        Pageable pageable = PageRequest.of(page, size, sort);
        return jpaRepository.findAll(pageable);
    }
}