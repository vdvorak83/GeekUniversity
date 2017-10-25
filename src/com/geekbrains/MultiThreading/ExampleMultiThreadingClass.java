package com.geekbrains.MultiThreading;

public class ExampleMultiThreadingClass {
    private final Object mon = new Object();
    private char currentLetter = 'A';

    public static void main_1() {
        MyThread mt = new MyThread(); // первый вариант создания потока, наследование от класса Thread
        Thread rt = new Thread(new MyRunnable()); // второй вариант создания потока, передача в конструктор класса Thread, экземпляра класса имплементирующего интерфейс Runnable


        new Thread(() -> {
            System.out.println("lyambda thread");
        }).start();


        System.out.println(Thread.currentThread().getName());

        mt.start();
        rt.start();

        System.out.println("Main app started");

    }

    public static void main_2() {
        Counter counter = new Counter();
        Thread threadInc = new Thread(() -> {
            for (int i =0; i < 1000000; i++) {
                counter.inc();
            }
            System.out.println("Inc ended");
        });

        Thread threadDec = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.dec();
            }
            System.out.println("Dec ended");
        });

        threadInc.start();
        threadDec.start();

        try {
            threadInc.join();
            threadDec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getC());
    }

    public void main_3() {
        Box box_1 = new Box();
        Box box_2 = new Box();

        new Thread(() -> box_1.doSomething()).start();
        new Thread(() -> box_2.doSomething()).start();
    }

    public void main_4() {
        Box box = new Box();

        new Thread(() -> box.doSomething()).start();
        new Thread(() -> box.doSomething()).start();
    }

    public void main_5() {
       Thread timer = new Thread(() ->{
          int seconds = 0;

           while (!Thread.currentThread().isInterrupted()){
               seconds++;
               System.out.println("Second: " + seconds);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();// после этого Exception, флаг interrupted снимается и цикл продолжится
                   break;
               }
           }
       });

       //timer.setDaemon(true);
       timer.start();

       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       timer.interrupt();
    }

    public void main_6(){
        ExampleMultiThreadingClass ls = new ExampleMultiThreadingClass();
        new Thread(() -> ls.printA()).start();
        new Thread(() -> ls.printB()).start();
    }

    private void printA(){
        synchronized (mon){
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter != 'A'){
                        mon.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    mon.notify();
                }

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void printB(){
        synchronized (mon){
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter != 'B'){
                        mon.wait();
                    }
                    System.out.println(currentLetter);
                    currentLetter = 'A';
                    mon.notify();
                }

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    class Box {
        final Object monitor = new Object();
        void doSomething(){
            System.out.println("No Synch block start with: " + Thread.currentThread().getName());
            System.out.println(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
            System.out.println("No Synch block ended with: " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitor){
                System.out.println("Synch block start with: " + Thread.currentThread().getName());
                System.out.println(1);
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(2);
                System.out.println("Synch block ended with: " + Thread.currentThread().getName());
            }
        }
    }
}
