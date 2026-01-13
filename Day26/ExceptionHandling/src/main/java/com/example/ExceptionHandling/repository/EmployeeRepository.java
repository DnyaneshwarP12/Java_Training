package com.example.ExceptionHandling.repository;

import com.example.ExceptionHandling.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
