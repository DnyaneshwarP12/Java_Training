package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("10101")
    private int rollNo;
    @Value("Amol")
    private String name;
    @Value("75.65f")
    private float marks;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public void display(){
        System.out.println("Name:"+name);
        System.out.println("RollNo:"+rollNo);
        System.out.println("MArks:"+marks);
    }
}
