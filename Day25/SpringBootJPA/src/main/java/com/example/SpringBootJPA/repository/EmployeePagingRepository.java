package com.example.SpringBootJPA.repository;

import com.example.SpringBootJPA.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePagingRepository extends PagingAndSortingRepository<Employee, Long> {
}