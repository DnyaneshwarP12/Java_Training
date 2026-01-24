package com.example.SpringBootScheduling.schedular;

import com.example.SpringBootScheduling.service.SchedulerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportScheduler {


    private final SchedulerService SchedulerService;


    public ReportScheduler(SchedulerService SchedulerService) {
        this.SchedulerService = SchedulerService;
    }


    @Scheduled(cron = "0 */10 * * * ?")
    public void generateReport() {
        System.out.println("Report generation started at " + LocalDateTime.now());


        // Simulate report processing
        SchedulerService.sendScheduler("Report generated successfully");


        System.out.println("Scheduler finished triggering async task");
    }
}