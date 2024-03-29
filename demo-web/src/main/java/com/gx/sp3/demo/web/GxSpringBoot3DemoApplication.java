package com.gx.sp3.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GxSpringBoot3DemoApplication {
    public static void main(String args[]) {
        System.out.printf("!!! GxWebApplication#main entering");
        SpringApplication.run(GxSpringBoot3DemoApplication.class, args);
    }
}
