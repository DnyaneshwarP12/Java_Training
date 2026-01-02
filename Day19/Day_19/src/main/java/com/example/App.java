package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import resources.SpringConfig;
import com.example.Student;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) context.getBean("student");
        student.display();
    }
}
