package com.example.EmployeeApp.repository;

import com.example.EmployeeApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
