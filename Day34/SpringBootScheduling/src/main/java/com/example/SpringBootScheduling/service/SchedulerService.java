package com.example.SpringBootScheduling.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {


    @Async("taskExecutor")
    public void sendScheduler(String message) {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Notification sent: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}