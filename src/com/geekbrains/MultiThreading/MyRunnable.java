package com.geekbrains.MultiThreading;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runn" + Thread.currentThread().getName() + i);
        }
    }
}
