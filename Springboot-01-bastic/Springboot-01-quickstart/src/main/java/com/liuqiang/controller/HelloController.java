package com.liuqiang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String test01(){
        System.out.println("spring boot 01 application running.............");
        return "spring boot 01 application running.............";
    }
}
