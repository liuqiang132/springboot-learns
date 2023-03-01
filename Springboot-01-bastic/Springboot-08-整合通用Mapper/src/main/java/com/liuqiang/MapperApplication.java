package com.liuqiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.liuqiang.mapper")//此处容易倒错包
public class MapperApplication {
    public static void main(String[] args) {

        SpringApplication.run(MapperApplication.class,args);
    }
}
