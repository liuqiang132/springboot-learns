package com.liuqiang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//跨域解决
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true) //是否发送cookie
                .allowedOrigins("*") //放行哪些原始禹
                .allowedMethods("POST","GET","PUT","DELETE")
                .allowedMethods("*");


    }
}
