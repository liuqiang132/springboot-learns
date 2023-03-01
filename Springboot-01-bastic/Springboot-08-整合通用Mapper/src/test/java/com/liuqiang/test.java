package com.liuqiang;

import com.liuqiang.entity.TblBook;
import com.liuqiang.mapper.TblBookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = MapperApplication.class)
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private TblBookMapper tblBookMapper;

    //全部查询
    @Test
    public void test01(){

        List<TblBook> tblBooks = tblBookMapper.selectAll();
        for (TblBook tblBook : tblBooks) {
            System.out.println(tblBook);
        }

    }
    //按id查询
    @Test
    public void test02(){

        TblBook tblBook = tblBookMapper.selectByPrimaryKey(3);
        System.out.println(tblBook);

    }
    //删除
    @Test
    public void test03(){
        int i = tblBookMapper.deleteByPrimaryKey(1832673844);
        System.out.println("删除成功！");
    }
}
