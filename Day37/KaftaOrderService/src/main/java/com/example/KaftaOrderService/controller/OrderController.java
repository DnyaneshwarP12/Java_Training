package com.example.KaftaOrderService.controller;

import com.example.KaftaOrderService.Service.OrderProducer;
import com.example.KaftaOrderService.entity.OrderEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderEvent order) {
        order.setStatus("CREATED");
        producer.sendOrder(order);
        return "Order event published to Kafka";
    }
}
