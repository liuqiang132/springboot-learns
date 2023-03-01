package com.liuqiang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/books")
    public String hello(){

        System.out.println("我爱你解鲁瑶");
        return "springboot";
    }
}
