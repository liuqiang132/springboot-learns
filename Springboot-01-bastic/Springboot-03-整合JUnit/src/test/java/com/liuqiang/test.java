package com.liuqiang;

import com.liuqiang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 在此测试即可
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private User user;

    @Test
    public void test01(){
        System.out.println(user);
    }
}
