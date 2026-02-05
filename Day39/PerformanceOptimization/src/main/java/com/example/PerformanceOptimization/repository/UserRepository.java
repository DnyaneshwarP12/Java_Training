package com.example.PerformanceOptimization.repository;

import com.example.PerformanceOptimization.dto.UserOrderDTO;
import com.example.PerformanceOptimization.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // BAD: Triggers N+1
    List<User> findAll();

    // GOOD: Fetch Join
    @Query("SELECT u FROM User u JOIN FETCH u.orders")
    List<User> findAllWithOrders();

    // BEST: DTO Projection
    @Query("SELECT new com.example.PerformanceOptimization.dto.UserOrderDTO(u.name, o.amount) " +
            "FROM User u JOIN u.orders o")
    List<UserOrderDTO> fetchUserOrders();

}

