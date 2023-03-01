package com.liuqiang.fun;

import lombok.Data;

@Data
public class DemoModule {

    private String version;

    private String name;

    private  String address;

    public String exeModuleMethod() {
        return "Demo module, name = " + name + ", version = " + version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}