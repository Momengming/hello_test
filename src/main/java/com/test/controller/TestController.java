package com.test.controller;

import com.test.domain.Result;
import com.test.domain.Test;
import com.test.repository.TestRepository;
import com.test.service.TestService;
import com.test.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestService testService;

    @PostMapping(value = "/test/add")
    public Result<Test> add(@RequestBody Test test){
        return ResultUtil.success(testRepository.save(test));
    }

    /**
     * 获取所有数据
     * @return
     */
    @GetMapping(value = "/test/list")
    public List<Test> list(){
        return testRepository.findAll();
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @PostMapping(value = "/test/search/{id}")
    public Test getTestById(@PathVariable("id") Integer id){
        return testRepository.findById(id).orElse(null);
    }

    /**
     * 通过Id删除
     * @param id
     */
    @DeleteMapping(value = "/test/delete/{id}")
    public void testDelete(@PathVariable("id") Integer id){
        testRepository.deleteById(id);
    }

    /**
     * 修改
     * @param id
     * @param test
     * @return
     */
    @PostMapping(value = "/test/update/{id}")
    public Test testUpdate(@PathVariable("id") Integer id,@RequestBody Test test){
        test.setId(id);
        return testRepository.save(test);
    }

    @PostMapping(value = "/test/getNameById/{id}")
    public String getNameById(@PathVariable("id") Integer id){

        Test test = testRepository.findById(id).orElse(null);

        return test.getName();
    }
}
