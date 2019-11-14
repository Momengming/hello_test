package com.test.service;

import com.test.domain.Test;
import com.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService{

    @Autowired
    TestRepository testRepository;

    @Transactional
    public void insertTwoTest(){
        Test test = new Test();
        test.setName("test1");
        test.setScore(99.0);
        test.setAge(20);
        testRepository.save(test);
    }


}
