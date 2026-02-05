package com.example.PerformanceOptimization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDTO {

    private String userName;
    private Double amount;
}
