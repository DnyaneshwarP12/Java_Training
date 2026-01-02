package com.springapp.service;

import com.springapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void printStudent() {
        System.out.println("Student Name: " + repository.getStudentName());
    }
}
