package com.liuqiang;


import com.liuqiang.entity.Student;
import com.liuqiang.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = MpApplication.class)
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test01(){
        List<Student> students = studentMapper.selectList(null);
        for (Student student : students) {
            System.out.println(student);
        }

    }


}
