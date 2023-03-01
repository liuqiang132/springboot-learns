package com.liuqiang.mapper;

import com.liuqiang.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    //根据id查询
    @Select("select *from student where id = #{id} ")
     Student getStudentById(Integer id);

    //查询所有数据
    @Select("select *from student")
    List<Student> findAll();
}
