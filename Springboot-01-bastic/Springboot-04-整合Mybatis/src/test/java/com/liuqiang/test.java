package com.liuqiang;


import com.liuqiang.entity.Student;
import com.liuqiang.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest(classes = MybatisApplication.class)
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test01(){
        Student studentById = studentMapper.getStudentById(3);
        System.out.println(studentById);
    }
    @Test
    public void test02(){
        List<Student> studentList = studentMapper.findAll();
        //studentList.forEach(System.out::print);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}
