package com.boge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.boge.mapper")
@SpringBootApplication
public class MybatisSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootApplication.class, args);
    }

}
