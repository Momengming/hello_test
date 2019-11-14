package com.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class) //修改运行方式
@Suite.SuiteClasses({ordinaryTest.class}) //要测试的类
public class batchTest {

}
