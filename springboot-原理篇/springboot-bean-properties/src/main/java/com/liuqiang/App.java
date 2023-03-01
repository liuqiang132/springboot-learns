package com.liuqiang;

import com.liuqiang.bean.CartoonCatAndMouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@Import(CartoonCatAndMouse.class)
public class App {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        String[] definitionNames = run.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }

    }
}
