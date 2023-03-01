package com.liuqiang.auto;

import com.liuqiang.fun.PersonFun;
import com.liuqiang.properties.PersonProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = PersonProperties.class)
public class PersonAutoConfiguration {

    @Bean
    public PersonFun personFun(PersonProperties personProperties){
        PersonFun personFun = new PersonFun();
        personFun.setName(personProperties.getPersonName());
        personFun.setEmail(personProperties.getEmail());
        personFun.setAddress(personProperties.getAddress());
        return personFun;
    }
}
