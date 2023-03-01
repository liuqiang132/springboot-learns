package com.liuqinag;

import com.liuqiang.WebMockApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


/**
 * webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT  web测试
 */
@SpringBootTest(classes = WebMockApp.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
//开启MVC的虚拟调用
@AutoConfigureMockMvc
public class test {
    @Autowired
    private MockMvc mockMvc;

    //发送虚拟请求
    @Test
    public void test01() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mockMvc.perform(builder);
        System.out.println(perform.andReturn());

    }
}
