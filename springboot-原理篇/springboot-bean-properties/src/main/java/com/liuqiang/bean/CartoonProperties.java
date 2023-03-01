package com.liuqiang.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自动配置类
 */
@ConfigurationProperties(prefix = "cartoon")
public class CartoonProperties {
    private Cat cat;
    private Mouse mouse;

    public CartoonProperties(Cat cat, Mouse mouse) {
        this.cat = cat;
        this.mouse = mouse;
    }

    public CartoonProperties() {
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "CartoonProperties{" +
                "cat=" + cat +
                ", mouse=" + mouse +
                '}';
    }
}
