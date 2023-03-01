package com.liuqiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
    //加载第三方的bean方式
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

}
