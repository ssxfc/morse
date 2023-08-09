package com.morse.rtos;

import com.morse.rtos.biz.mapper.UserMapper;
import com.morse.rtos.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.morse.rtos.biz.mapper")
public class UserApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(UserApplication.class, args);
    }
}
