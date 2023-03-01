package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {

    private static final Map<String,Integer> ipCountMap = new HashMap<String,Integer>();

    @Autowired
    private HttpServletRequest httpServletRequest;
    public void count(){
        //获取到本地ip地址
        String ip = httpServletRequest.getLocalAddr();
        if (ipCountMap.containsKey(ip)){
            ipCountMap.put(ip, ipCountMap.get(ip)+1);
        }else {
            ipCountMap.put(ip,1);
        }

    }
    @Scheduled(cron = "0/1 * * * * ?")
    public void print(){
        System.out.println("         开启ip监控");
        System.out.println("+-----ip地址----+--num--+");
        for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("|%16s |%4d|%n",key,value);
        }
        System.out.println("+---------------+------+");
    }

}
