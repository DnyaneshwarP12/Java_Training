package com.example.SecurityConfig.controller;


import com.example.SecurityConfig.entity.UserEntity;
import com.example.SecurityConfig.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping("/{create}")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return repository.save(user);
    }
}

