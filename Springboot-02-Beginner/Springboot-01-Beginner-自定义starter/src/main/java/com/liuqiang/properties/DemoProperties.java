package com.liuqiang.properties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "com.liuqiang")
public class DemoProperties implements Serializable {
    private String version;
    private String name;
    private String address;

}
