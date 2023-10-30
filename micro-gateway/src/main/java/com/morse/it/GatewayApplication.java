package com.morse.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhangwenwu
 * @Date 2023/10/30 20:41
 * @Version 1.8
 */

@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run((GatewayApplication.class));
    }
}
