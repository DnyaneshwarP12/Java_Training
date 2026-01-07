package com.example.EmployeeManagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Name;
import lombok.Data;
import lombok.Value;

@Data
public class EmployeeDTO {

    private Long Id;
    @NotBlank(message = "Name is mandatory")
    private String Name;
    @NotBlank(message = "Department is mandatory")
    private String Department;
    private String Salary;

}
