package com.example.SwaggerOpenAPI.repository;

import com.example.SwaggerOpenAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
}
