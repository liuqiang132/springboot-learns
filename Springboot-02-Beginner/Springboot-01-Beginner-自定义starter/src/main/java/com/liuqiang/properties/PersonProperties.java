package com.liuqiang.properties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "person.liuqiang")
public class PersonProperties {
    private Integer personId;
    private String  personName;
    private Integer age;
    private String address;
    private String email;

}
