package com.liuqiang.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //反射加载
        try {
            Class<?> clzz = Class.forName("con.liuqiang.bean.Mouse");
            if (clzz!=null){
                return new String[]{"com.liuqiang.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new String[0];

        }


        return null;
    }
}
