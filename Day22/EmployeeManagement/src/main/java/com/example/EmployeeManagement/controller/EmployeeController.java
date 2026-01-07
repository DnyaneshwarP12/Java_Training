package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.dto.EmployeeDTO;
import com.example.EmployeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {

        this.service = service;
    }

    // CREATE
    @PostMapping("/{create}")
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO EmployeeDTO) {
        return new ResponseEntity<>(service.createEmployee(EmployeeDTO), HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {

        return ResponseEntity.ok(service.getAllEmployees());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        EmployeeDTO Employee = service.getEmployeeById(id);
        if (Employee != null) {
            return ResponseEntity.ok(Employee);
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id,
                                          @RequestBody EmployeeDTO EmployeeDTO) {
        EmployeeDTO updated = service.updateEmployee(id, EmployeeDTO);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.deleteEmployee(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

