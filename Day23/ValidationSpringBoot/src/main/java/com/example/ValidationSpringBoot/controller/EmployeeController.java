package com.example.ValidationSpringBoot.controller;

import com.example.ValidationSpringBoot.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @PostMapping("/users")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO request) {
        return ResponseEntity.ok("User is valid");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody EmployeeDTO request,
            BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok("Success");
    }
}
