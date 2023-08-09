package com.morse.rtos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("morse-user")
public interface UserFeign {

    @GetMapping("/user/get")
    String getDefaultUserName();
}
