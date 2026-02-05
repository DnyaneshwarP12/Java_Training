package com.example.PerformanceOptimization.service;

import com.example.PerformanceOptimization.dto.UserOrderDTO;
import com.example.PerformanceOptimization.entity.User;
import com.example.PerformanceOptimization.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    private final UserRepository userRepository;

    public PerformanceService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> lazyLoadingProblem() {
        return userRepository.findAll();
    }

    public List<User> fetchJoinSolution() {
        return userRepository.findAllWithOrders();
    }

    public List<UserOrderDTO> dtoSolution() {
        return userRepository.fetchUserOrders();
    }
}
