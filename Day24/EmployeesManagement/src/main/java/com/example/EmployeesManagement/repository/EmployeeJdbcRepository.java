package com.example.EmployeesManagement.repository;

import com.example.EmployeesManagement.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Employee e) {
        return jdbcTemplate.update(
                "INSERT INTO employee(name, salary) VALUES (?, ?)",
                e.getName(), e.getSalary()
        );
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query(
                "SELECT id, name, salary FROM employee",
                (rs, rowNum) -> {
                    Employee emp = new Employee();
                    emp.setId(rs.getLong("id"));
                    emp.setName(rs.getString("name"));
                    emp.setSalary(rs.getDouble("salary"));
                    return emp;
                }
        );
    }
}
