package com.example.SpringBootJPA.repository;

import com.example.SpringBootJPA.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Long> {
}