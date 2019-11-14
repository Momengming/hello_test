package com.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@WebAppConfiguration //用来声明加载的类是一个WebApplicationContext
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {
    @Autowired
    private TestRepository testRepository;

//    事物回滚
    @Test
    @Transactional
    @Rollback(value = false) //不发生回滚
    public void testhuigun(){

        com.test.domain.Test test = new com.test.domain.Test();
        test.setAge(18);
        test.setName("xiaohong");
        test.setScore(100.0);
        testRepository.save(test);

        com.test.domain.Test test1 = new com.test.domain.Test();
        test1.setAge(Integer.parseInt("sss"));
        test1.setName("xiaoming");
        test1.setScore(10.0);
        testRepository.save(test);
    }
}