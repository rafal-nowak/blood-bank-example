package com.amigoscode.bbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BBExampleApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BBExampleApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(BBExampleApplication.class, args);
    }

}
