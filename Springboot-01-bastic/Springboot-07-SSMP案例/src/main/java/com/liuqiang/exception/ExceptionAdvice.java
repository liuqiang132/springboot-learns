package com.liuqiang.exception;

import com.liuqiang.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//统一异常处理
@RestControllerAdvice
public class ExceptionAdvice {

    //拦截所有的异常
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        //记录日志
        //通知运维
        //发送邮件
        e.printStackTrace();
        return Result.builder().flag(false).data(null).message("服务器异常,请稍后再试！").build();
    }



}
