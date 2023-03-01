package com.liuqiang;

import com.liuqiang.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//扫描当前的包及其子包
@SpringBootApplication
public class QuickStart01Application {
    public static void main(String[] args) {

        ApplicationContext run = SpringApplication.run(QuickStart01Application.class, args);
        HelloController bean = run.getBean(HelloController.class);
        System.out.println("bean===>"+bean);//bean===>com.liuqiang.controller.HelloController@6650813a

    }
}
