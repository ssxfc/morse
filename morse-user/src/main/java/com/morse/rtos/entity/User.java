package com.morse.rtos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    private Integer id;
    private String name;
    private Integer age;
}