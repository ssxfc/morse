package com.morse.it.handler.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @Author zhangwenwu
 * @Date 2023/11/11 23:56
 * @Version 1.8
 */
public class MyStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("my stop event handler");
    }
}
