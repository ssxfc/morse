package com.morse.it.handler.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangwenwu
 * @Date 2023/11/11 23:59
 * @Version 1.8
 */
@Configuration
public class MyEventHandlerConfig {
    @Bean
    public ApplicationListener getRefreshedHandler(){
        return new MyRefreshedEventHandler();
    }

    @Bean
    public ApplicationListener getStartHandler(){
        return new MyStartEventHandler();
    }

    @Bean
    public ApplicationListener getStopHandler(){
        return new MyStopEventHandler();
    }
}
