package com.example.demoq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoqApplication extends SpringBootServletInitializer {

//    public static void main(String[] args) {
//
//        SpringApplication.run(DemoqApplication.class, args);
//
//
//    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoqApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(
                DemoqApplication.class);
        sa.run(args);
    }

}
