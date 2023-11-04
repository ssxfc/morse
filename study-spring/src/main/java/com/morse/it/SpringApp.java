package com.morse.it;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhangwenwu
 * @Date 2023/11/2 0:58
 * @Version 1.8
 */
public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Object student = ctx.getBean("student");
        System.out.println(student);
    }
}
