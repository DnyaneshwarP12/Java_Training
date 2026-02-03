package com.example.KaftaNotificationService.entity;

import lombok.Data;

@Data
public class OrderEvent {

    private Long orderId;
    private String product;
    private double amount;
    private String status;

}
