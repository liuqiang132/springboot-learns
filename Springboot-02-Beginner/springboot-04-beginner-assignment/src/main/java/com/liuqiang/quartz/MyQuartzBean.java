package com.liuqiang.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
 public class MyQuartzBean {


    @Scheduled(cron = "1/1 * * * * ?")
    public void printf(){
        //获取系统当前的时间
        System.out.println(Thread.currentThread().getName()+":spring task running ............"+ LocalDate.now());
    }
}
