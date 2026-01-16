package com.example.jwtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class UserController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard - Access Granted";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "User Profile - JWT Secured";
    }
}
