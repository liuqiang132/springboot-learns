package com.example.autoConfig;


import com.example.service.IpCountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务
@EnableScheduling
public class IPAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public IpCountService ipCountService(){
        return new IpCountService();
    }

}
