package com.example.controller;

import com.example.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IPController {


    @Autowired
    private IpCountService ipCountService;

    @GetMapping("/test")
    public String test01(){
        ipCountService.count();
        return "springboot service running .........";
    }


}
