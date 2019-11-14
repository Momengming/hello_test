package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
@WebAppConfiguration //用来声明加载的类是一个WebApplicationContext
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    protected MockMvc mockMvc;

    //开始时间
    long startTimeMillis;

    //结束时间
    long endTimeMillis;


    @Autowired
    WebApplicationContext wac;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        System.out.println("开始测试");
        startTimeMillis=System.currentTimeMillis();
    }

    @After
    public void tearDown() throws Exception {
        endTimeMillis= System.currentTimeMillis();
        System.out.println("结束测试【耗时】" + (endTimeMillis - startTimeMillis));
    }
}