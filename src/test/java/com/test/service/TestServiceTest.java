package com.test.service;

import com.test.repository.TestRepository;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @InjectMocks
    @Autowired
    private TestService testService;

    @Mock
    TestRepository testRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByAge() {
        testRepository.findByAge(21);//返回NULL
        List<com.test.domain.Test> testList = testService.findByAge(21);
        Mockito.verify(testRepository).findByAge(20);
        Mockito.verify(testRepository).findByAge(21);
        assertThat("预期结果不对",testList.get(0).getScore(),is(99));

    }

}