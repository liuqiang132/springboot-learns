package com.liuqiang.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzApp extends QuartzJobBean {
    /* 相关概念:
     *   工作(job): 用于定义具体的执行的工作
     *   工作明细(jobDetail): 用于描述定时工作相关的信息
     *   触发器(Trigger): 用于描述触发器工作的规则，通常使用cron表达定义调度的规则
     *   调度器(Scheduler):描述了工作明细与触发器的对应关系
     *
     *
     *
     */
    @Override
    protected void executeInternal(JobExecutionContext Context) throws JobExecutionException {

        System.out.println("我爱你解鲁瑶");


    }


}
