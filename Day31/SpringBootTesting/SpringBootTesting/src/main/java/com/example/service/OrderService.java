package com.example.service;

import com.example.model.Order;
import com.example.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double calculateTotal(double price, int quantity) {
        if (price <= 0 || quantity <= 0) {
            throw new IllegalArgumentException("Invalid price or quantity");
        }
        return price * quantity;
    }

    public Order placeOrder(double price, int quantity) {
        double total = calculateTotal(price, quantity);
        Order order = new Order(price, quantity);
        return orderRepository.save(order);
    }
}

