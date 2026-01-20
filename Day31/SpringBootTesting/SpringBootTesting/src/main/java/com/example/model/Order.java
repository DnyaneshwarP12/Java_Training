package com.example.model;


public class Order {

    private double price;
    private int quantity;

    public Order(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
