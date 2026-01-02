package com.springapp;

import com.springapp.config.AppConfig;
import com.springapp.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService service = context.getBean(StudentService.class);
        service.printStudent();

        context.close();
    }
}
