package com.test.service;

import com.test.domain.Test;
import com.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService{

    @Autowired
    private TestRepository testRepository;


    public List<Test> findByAge(int age) {
        return testRepository.findByAge(age);
    }
}
