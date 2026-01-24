package com.example.SpringBootScheduling.controller;

import com.example.SpringBootScheduling.service.SchedulerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SchedulerController {


    private final SchedulerService SchedulerService;


    public SchedulerController(SchedulerService SchedulerService) {
        this.SchedulerService = SchedulerService;
    }


    @GetMapping("/notify")
    public String sendScheduler() {
        SchedulerService.sendScheduler("Manual Scheduler");
        return "Scheduler request accepted";
    }
}