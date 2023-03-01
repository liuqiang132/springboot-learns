package com.liuqiang;

import com.liuqiang.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = MongodbApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    //注入对象
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 一系列的增删改查,文档操作
     */
    @Test
    public void test01(){
        List<Book> all = mongoTemplate.findAll(Book.class);
        all.forEach(System.out::println);
    }
}
