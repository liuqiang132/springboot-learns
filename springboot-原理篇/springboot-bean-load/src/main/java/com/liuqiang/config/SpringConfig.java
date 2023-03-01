package com.liuqiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.liuqiang.bean.Cat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

//@Import(MyImportSelector.class)
public class SpringConfig {

    /**
     * @ConditionalOnClass(Mouse.class)
     * 这句话的意思是:当发现Mouse这个类则创建这个cat对象
     *
     * @ConditionalOnMissingClass("com.liuqiang.bean.Wolf")
     * 这句话的意思是: 当没有找到这个类的时候创建cat对象
     * @return
     */
    @Bean
    @ConditionalOnClass(name = "com.liuqiang.bean.Dog")
//    @ConditionalOnMissingClass("com.liuqiang.bean.Mouse")
    public Cat cat(){
        return new Cat();
    }



    @Bean
    @ConditionalOnClass(name = "com.mysql.jdbc.Driver")
    public DruidDataSource dataSource()
    {
        return new DruidDataSource();
    }

}
