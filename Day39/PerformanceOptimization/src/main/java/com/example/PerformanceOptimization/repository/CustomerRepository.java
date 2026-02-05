package com.example.PerformanceOptimization.repository;

import com.example.PerformanceOptimization.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Fix N+1 using EntityGraph
    @EntityGraph(attributePaths = "addresses")
    List<Customer> findAll();
}
