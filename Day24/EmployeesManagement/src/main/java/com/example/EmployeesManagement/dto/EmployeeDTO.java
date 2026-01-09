package com.example.EmployeesManagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private double salary;

    private Long departmentId;
    private AddressDTO address;
    private List<Long> projectIds;

}
