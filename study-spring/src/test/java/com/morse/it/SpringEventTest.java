package com.morse.it;

import com.morse.it.handler.event.MyEventHandlerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @Author zhangwenwu
 * @Date 2023/11/11 23:55
 * @Version 1.8
 */
public class SpringEventTest {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(MyEventHandlerConfig.class);
//        ctx.start();
//        ctx.refresh();
//        ctx.stop();
    }
}
