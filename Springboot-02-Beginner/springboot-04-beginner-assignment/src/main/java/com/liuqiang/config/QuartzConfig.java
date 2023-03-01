package com.liuqiang.config;

import com.liuqiang.quartz.QuartzApp;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        //绑定具体的工作
        return JobBuilder.newJob(QuartzApp.class).storeDurably().build();
    }
    @Bean
    public Trigger trigger(JobDetail jobDetail){
        //绑定对应的工作细则
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail).withSchedule(scheduleBuilder).build();
    }

}
