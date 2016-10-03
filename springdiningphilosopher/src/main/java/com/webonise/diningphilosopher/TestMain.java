package com.webonise.diningphilosopher;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TestMain.class, args);
        Application application = context.getBean(Application.class);
        application.start();
    }
}