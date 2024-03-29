package com.gx.sp3.demo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
    basePackages = {"com.gx"}
)
@MapperScan("com.gx.sp3.demo.dao.mapper")
public class GxSpringBoot3DemoApplication {
    public static void main(String args[]) {
        System.out.printf("!!! GxSpringBoot3DemoApplication#main entering");
        SpringApplication.run(GxSpringBoot3DemoApplication.class, args);
    }
}
