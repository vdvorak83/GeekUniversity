package com.geekbrains.Reflection;

public class TestingClass {

    @BeforeSuite
    public void beforeSuiteMethod(){

    }

    @AfterSuite
    public void afterSuite(){

    }

    @Test(priority = 1)
    public void test1(){

    }
    @Test(priority = 2)
    public void test2(){

    }
    @Test(priority = 2)
    public void test3(){

    }
    @Test(priority = 3)
    public void test4(){

    }
}
