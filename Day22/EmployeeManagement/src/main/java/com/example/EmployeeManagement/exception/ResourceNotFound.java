package com.example.EmployeeManagement.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
        super();
    }

    // Constructor with message (IMPORTANT)
    public ResourceNotFound(String message) {
        super(message);
    }
}

