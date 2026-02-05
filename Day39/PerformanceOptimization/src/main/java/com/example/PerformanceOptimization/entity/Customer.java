package com.example.PerformanceOptimization.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Address> addresses;
}
