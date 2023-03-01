package com.liuqiang.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@ConfigurationProperties(prefix = "user")
public class User implements Serializable {
    private String name;
    private Integer age;
    private String address;
}
