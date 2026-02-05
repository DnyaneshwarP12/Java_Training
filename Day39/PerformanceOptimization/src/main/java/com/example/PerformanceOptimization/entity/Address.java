package com.example.PerformanceOptimization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String city;

    @ManyToOne
    private Customer customer;
}
