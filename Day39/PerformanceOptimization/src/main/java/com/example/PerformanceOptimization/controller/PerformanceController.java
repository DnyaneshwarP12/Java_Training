package com.example.PerformanceOptimization.controller;

import com.example.PerformanceOptimization.dto.UserOrderDTO;
import com.example.PerformanceOptimization.entity.User;
import com.example.PerformanceOptimization.service.PerformanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    private final PerformanceService service;

    public PerformanceController(PerformanceService service) {
        this.service = service;
    }

    @GetMapping("/lazy")
    public List<User> lazy() {
        return service.lazyLoadingProblem();
    }

    @GetMapping("/fetch-join")
    public List<User> fetchJoin() {
        return service.fetchJoinSolution();
    }

    @GetMapping("/dto")
    public List<UserOrderDTO> dto() {
        return service.dtoSolution();
    }
}
