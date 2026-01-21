package com.example.SwaggerOpenAPI.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Operation(summary = "Login and generate JWT token")
    @PostMapping("/login")
    public String login() {
        return "JWT_TOKEN";
    }
}