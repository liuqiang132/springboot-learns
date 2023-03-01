package com.liuqiang.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController2 {


    @GetMapping("/msg/{iphone}")
    @Cacheable(value = "cacheSpace",key = "#iphone ")
    public String msg(@PathVariable("iphone") String iphone){
        String substring = iphone.substring(iphone.length() - 6);
        return substring;

    }
    @GetMapping("/checkCode/{iphone}/{code}")
    @Cacheable(value = "cacheSpace",key = "#iphone")
    public Boolean checkCode(@PathVariable("iphone") String iphone,@PathVariable("code") String code){

       return  iphone.equals(code);


    }




}
