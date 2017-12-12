package com.geekbrains.Reflection;

import com.geekbrains.MultiThreading.MultiThreadingCalculate;

import java.io.Serializable;

public class TestingClass  {

    @BeforeSuite
    public void beforeSuiteMethod(){
        printTestMessage("Bufore suite test");
    }
    @AfterSuite
    public void afterSuite(){
        printTestMessage("After suite test");
    }
    @Test(priority = 1)
    public void test1(){
        printTestMessage("Test 1");
    }
    @Test(priority = 2)
    public void test2(){
        printTestMessage("Test 2");
    }
    @Test(priority = 7)
    public void test3(){
        printTestMessage("Test 3");
    }
    @Test(priority = 5)
    public void test4(){
        printTestMessage("Test 4");
    }
    @Test(priority = 4)
    public void test5(){
        printTestMessage("Test 5");
    }
    @Test(priority = 3)
    public void test6(){
        printTestMessage("Test 6");
    }
    @Test(priority = 9)
    public void test7(){
        printTestMessage("Test 7");
    }
    @Test(priority = 8)
    public static void test8(){
        System.out.println(("Test 8"));
    }

    public void printTestMessage(String textMessage){
        System.out.println(textMessage);
    }
}
