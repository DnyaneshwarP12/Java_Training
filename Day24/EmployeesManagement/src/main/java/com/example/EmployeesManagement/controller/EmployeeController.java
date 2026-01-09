package com.example.EmployeesManagement.controller;

import com.example.EmployeesManagement.dto.EmployeeDTO;
import com.example.EmployeesManagement.entity.Employee;
import com.example.EmployeesManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Employee save(@RequestBody EmployeeDTO employeeDTO) {
        return service.save(employeeDTO);
    }


    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,
                           @RequestBody EmployeeDTO employeeDTO) {
        return service.update(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }
}
