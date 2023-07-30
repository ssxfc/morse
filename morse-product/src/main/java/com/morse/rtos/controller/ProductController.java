package com.morse.rtos.controller;

import com.morse.rtos.feign.UserFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private UserFeign userFeign;

    @RequestMapping("/getUserName")
    String getProduct(){
        return userFeign.getDefaultUserName();
    }
}
