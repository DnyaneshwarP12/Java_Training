package com.example.KaftaOrderService.entity;

import lombok.Data;

@Data
public class OrderEvent {

    private Long orderId;
    private String product;
    private double amount;
    private String status;

}
