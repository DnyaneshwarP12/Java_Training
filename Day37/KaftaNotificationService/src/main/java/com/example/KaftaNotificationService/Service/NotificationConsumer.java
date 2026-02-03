package com.example.KaftaNotificationService.Service;

import com.example.KaftaNotificationService.entity.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void consume(OrderEvent event) {
        System.out.println("📩 Order received:");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Product: " + event.getProduct());
        System.out.println("Amount: " + event.getAmount());
        System.out.println("Status: " + event.getStatus());
        System.out.println("Notification sent ✔️");
    }
}
