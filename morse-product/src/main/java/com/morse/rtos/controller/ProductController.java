package com.morse.rtos.controller;

import com.morse.rtos.feign.UserFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final UserFeign userFeign;

    @RequestMapping("/getUserName")
    String getProduct(){
        return userFeign.getDefaultUserName();
    }
}
