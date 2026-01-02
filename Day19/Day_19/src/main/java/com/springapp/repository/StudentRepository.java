package com.springapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public String getStudentName() {
        return "Alice";
    }
}
