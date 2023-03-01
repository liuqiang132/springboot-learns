package com.liuqiang.controller;

import com.liuqiang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {



    //方式一:
    @Autowired
    private User user;

    //方式二:
    @Value("${person.name}")
    private String name;


    @Value("${person.age}")
    private  Integer age;


    //方式三:
    @Autowired
    private Environment environment;

    @GetMapping("/test01")
    public String test01(){
        System.out.println("方式一:"+user);
        System.out.println("方式二:"+name+"===================="+age);
        System.out.println("=======================================");
        System.out.println("方式三:"+environment.getProperty("person.name"));
        System.out.println("方式三:"+environment.getProperty("person.age"));
        return "spring boot configuration running.......";
    }
}
