package com.morse.it.handler.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @Author zhangwenwu
 * @Date 2023/11/11 23:56
 * @Version 1.8
 */
public class MyStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("my start event handler");
    }
}
