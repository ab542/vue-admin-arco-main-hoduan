package com.liying.back.graducation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.liying.back.graducation.mapper")

public class GraducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraducationApplication.class, args);
    }

}
