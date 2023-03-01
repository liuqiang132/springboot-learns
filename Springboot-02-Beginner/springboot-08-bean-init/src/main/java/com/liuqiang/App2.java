package com.liuqiang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");

//        //自定义bean的加载方式
//        Book bean = context.getBean(Book.class);
//        bean.print();
//
//        //第三方bean的加载方式
//        DruidDataSource bean1 = context.getBean(DruidDataSource.class);
//        System.out.println(bean1);

        String[] names = context.getBeanDefinitionNames();
            for (String name : names) {
            System.out.println(name);
        }

    }
}
