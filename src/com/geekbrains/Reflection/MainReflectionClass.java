package com.geekbrains.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainReflectionClass {
    public static void main(String[] args) throws Exception {
         start(TestingClass.class);
    }

    public static void start(Class c) throws Exception {
        List<Method> listMethods = new ArrayList<Method>();
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)){
                if (m.getAnnotation(Test.class).priority() < 1 || m.getAnnotation(Test.class).priority() > 10) throw new RuntimeException("Invaild priority value");
                listMethods.add(m);
            }
        }
        listMethods.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());

        for (Method m:methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if (listMethods.get(0).isAnnotationPresent(BeforeSuite.class)) throw new RuntimeException("Too many @BeforeSuite");
                listMethods.add(0,m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                if (listMethods.get(listMethods.size()-1).isAnnotationPresent(AfterSuite.class)) throw new RuntimeException("Too many @AfterSuite");
                listMethods.add(m);
            }
        }

        for (Method m : listMethods) {
            m.invoke(c.newInstance());
        }
    }
}
