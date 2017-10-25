package com.geekbrains.MultiThreading;

public class Counter {
    volatile int c;

    public Counter() {
        this.c = 0;
    }

    public String getC() {
        return "Counter" + " = " + c;
    }

    public synchronized void inc(){
        c++;
    }

    public synchronized void dec(){
        c--;
    }

}
