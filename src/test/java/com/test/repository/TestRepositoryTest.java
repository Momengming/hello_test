package com.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@WebAppConfiguration //用来声明加载的类是一个WebApplicationContext
//@RunWith(SpringRunner.class)
@RunWith(Parameterized.class)
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


    private String firstName;
    private String lastName;

    public TestRepositoryTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Parameterized.Parameters
    public static List<Object[]> param(){
        return Arrays.asList(new Object[][]{{"li","si"},{"zhang","san"}});
    }


    @Test
    public void test(){
        String name = firstName + " " + lastName;
        System.out.println(name);
        assertThat("结果不一样","li si",equalTo(name));
    }
}