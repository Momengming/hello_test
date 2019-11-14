package com.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.concurrent.TimeUnit;

/**
 * 普通测试
 */
public class ordinaryTest extends BaseTest{
    /**
     * 运行超出时间测试失败
     * @throws InterruptedException
     */
    @Test(timeout = 1000)
    @Ignore  //加上该注解测试类是该方法不测试。
    public void timeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("超时测试");
    }

    /**
     * 异常测试
     */
    @Test(expected = ArithmeticException.class)
    public void exceptiontest(){
        int i = 0;
        int j = 10;
        System.out.println(j/i);
    }
    @Test(expected = ArithmeticException.class)
    public void exceptiontest1(){
        String str = null;
        System.out.println(str.length());
    }
}
