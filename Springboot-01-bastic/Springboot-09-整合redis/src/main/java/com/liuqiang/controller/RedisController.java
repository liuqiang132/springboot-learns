package com.liuqiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/setGet")
    public void test01(){
        //redis中set get的使用
        for (int i = 0; i <1000; i++) {
            redisTemplate.opsForValue().set("name"+(i+1),"解路遥132"+i);
            System.out.println(redisTemplate.opsForValue().get("name"+(i+1)));
        }

    }
    @GetMapping("/inert")
    public String test02(){
        //redis中set get的使用
        Long view = redisTemplate.opsForValue().increment("view");
        return "你已经访问该网站:"+view+"次";
    }
}
