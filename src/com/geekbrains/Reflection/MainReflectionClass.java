package com.geekbrains.Reflection;

import java.lang.reflect.Method;

public class MainReflectionClass {
    public static void main(String[] args) {
         start(TestingClass.class);
    }

    public static void start(Class c){
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}
