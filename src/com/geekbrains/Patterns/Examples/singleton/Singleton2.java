package com.geekbrains.Patterns.Examples.singleton;

public class Singleton2 {
    private static Singleton2 ourInstance = new Singleton2();

    public static Singleton2 getInstance() {
        return ourInstance;
    }

    private Singleton2() {
    }
}
