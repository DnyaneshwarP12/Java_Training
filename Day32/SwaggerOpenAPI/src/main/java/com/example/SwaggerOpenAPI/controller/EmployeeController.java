package com.example.SwaggerOpenAPI.controller;

import com.example.SwaggerOpenAPI.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {


    @Operation(summary = "Get all employees")
    @GetMapping
    public List<Employee> getAll() {
        return List.of();
    }


    @Operation(summary = "Get employee by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{id}")
    public Employee getById(
            @Parameter(description = "Employee ID", example = "1")
            @PathVariable Long id) {
        return new Employee();
    }
}
