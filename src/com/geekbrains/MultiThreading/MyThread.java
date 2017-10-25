package com.geekbrains.MultiThreading;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thr" + Thread.currentThread().getName() + i);
        }
    }
}
