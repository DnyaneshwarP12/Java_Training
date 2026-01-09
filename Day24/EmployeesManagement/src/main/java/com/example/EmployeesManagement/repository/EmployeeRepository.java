package com.example.EmployeesManagement.repository;

import com.example.EmployeesManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
