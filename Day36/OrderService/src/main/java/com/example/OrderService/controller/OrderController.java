package com.example.OrderService.controller;



import com.example.OrderService.client.UserClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final UserClient userClient;

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/orders/message")
    public String getMessageFromUserService() {
        return userClient.getUserMessage();
    }
}
