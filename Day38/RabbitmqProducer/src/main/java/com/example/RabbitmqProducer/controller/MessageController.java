package com.example.RabbitmqProducer.controller;

import com.example.RabbitmqProducer.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer producer;

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return "Message sent to RabbitMQ";
    }
}
