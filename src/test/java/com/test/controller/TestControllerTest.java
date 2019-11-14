package com.test.controller;

import com.test.BaseTest;
import com.test.repository.TestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestControllerTest extends BaseTest {

    @Autowired
    TestRepository testRepository;

    @Test
    public void add() throws Exception{
        MvcResult mvcResult = super.mockMvc.perform(MockMvcRequestBuilders.post("/test/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"age\":21,\"name\":\"Tequila\",\"score\":99}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals("请求错误",200,status);

    }
    @Test
    public void list() throws Exception {
        MvcResult mvcResult = super.mockMvc.perform(MockMvcRequestBuilders.get("/test/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        System.out.println(responseString);
        Assert.assertEquals("请求错误",200,status);
    }

    @Test
    public void getTestById() throws Exception{
        MvcResult mvcResult = super.mockMvc.perform(MockMvcRequestBuilders.post("/test/search/2")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.age",is(18)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("请求错误",200,status);
        assertThat(status,is(200));
        assertThat("预期不等",status,is(100));
    }

    @Test
    public void testDelete() throws Exception{
        MvcResult mvcResult = super.mockMvc.perform(MockMvcRequestBuilders.delete("/test/delete/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("请求错误",200,status);
    }

    @Test
    public void testUpdate() throws Exception{
        MvcResult mvcResult = super.mockMvc.perform(MockMvcRequestBuilders.post("/test/update/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"age\":22,\"name\":\"tequila\",\"score\":99.9}")
            )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
//        Assert.assertEquals("修改失败",200,status);
    }

    @Test
    public void getNameById() throws Exception{
        MvcResult mvcResult = super.mockMvc.perform(MockMvcRequestBuilders.post("/test/getNameById/1")
                .accept(MediaType.ALL)
            )
                .andExpect(MockMvcResultMatchers.content().string(equalTo("Tequila")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}