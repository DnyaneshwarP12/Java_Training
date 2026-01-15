package com.example.SecurityConfig.repository;


import com.example.SecurityConfig.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
