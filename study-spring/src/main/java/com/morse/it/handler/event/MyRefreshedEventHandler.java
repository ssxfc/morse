package com.morse.it.handler.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author zhangwenwu
 * @Date 2023/11/11 23:56
 * @Version 1.8
 */
public class MyRefreshedEventHandler implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("my refreshed event handler");
    }
}
