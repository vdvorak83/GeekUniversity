package com.geekbrains.MultiThreading.Java_3_level;

public class methodExamples {
    Object monitor = new Object();
    private volatile char currentCharacter = 'A';

    public void printABC(){
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor){
                    while (currentCharacter != 'A'){
                        waitMonitor();
                    }
                    printAndNotify('B');
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor){
                    while (currentCharacter != 'B'){
                        waitMonitor();
                    }
                    printAndNotify('C');
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor){
                    while (currentCharacter != 'C'){
                        waitMonitor();
                    }
                    printAndNotify('A');
                }
            }
        }).start();
    }

    private void printAndNotify(char character) {
        System.out.print(currentCharacter);
        currentCharacter = character;
        monitor.notifyAll();
    }

    private void waitMonitor() {
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
