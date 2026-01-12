package com.example.SpringBootJPA.repository;

import com.example.SpringBootJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryBetween(double min, double max);
    List<Employee> findByNameLike(String pattern);

    //JPQL Query
    @Query("SELECT e FROM Employee e WHERE e.salary >:salary")
    List<Employee> findEmployeeWithHighSalary(@Param("salary") double salary );

    @Query(value = "SELECT * FROM employee WHERE department =?1", nativeQuery = true)
    List<Employee> findByDepartmentNative(String department);
}
