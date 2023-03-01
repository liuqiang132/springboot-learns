package com.liuqiang.auto;


import com.liuqiang.fun.DemoModule;
import com.liuqiang.properties.DemoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class AutoConfiguration {


    /**
     * 此时DemoModule对象中就已经注入的DemoProperties属性的值
     * 如果不自定义则使用默认即可,否则自定义
     *
     *
     * @param demoProperties
     * @return
     */
    @Bean
    public DemoModule demoModule(DemoProperties demoProperties){
        DemoModule module = new DemoModule();
        module.setName(demoProperties.getName());
        module.setVersion(demoProperties.getVersion());
        module.setAddress(demoProperties.getAddress());
        return module;

    }


}
