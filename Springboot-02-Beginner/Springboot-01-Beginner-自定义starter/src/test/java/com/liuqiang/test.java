package com.liuqiang;

import com.liuqiang.fun.DemoModule;
import com.liuqiang.fun.PersonFun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private DemoModule demoModule;

    @Autowired
    private PersonFun personFun;

    @Test
    public void test01(){

        System.out.println(demoModule);
        System.out.println(personFun);

    }
}
