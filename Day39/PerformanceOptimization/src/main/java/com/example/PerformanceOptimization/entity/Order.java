package com.example.PerformanceOptimization.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "orders",
        indexes = {
                @Index(name = "idx_order_user", columnList = "user_id")
        }
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
