package com.liuqiang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CacheController {


    private HashMap<String,String> cache = new HashMap<>();


    @GetMapping("/msg/{iphone}")
    public String msg(@PathVariable("iphone") String iphone){
        String stringIphone = iphone.substring(iphone.length() - 6);
        cache.put(iphone,stringIphone);
        return stringIphone;

    }
    @GetMapping("/checkCode/{iphone}/{code}")
    public Boolean checkCode(@PathVariable("iphone") String iphone,@PathVariable("code") String code){

       return  cache.get(iphone).equals(code);


    }




}
