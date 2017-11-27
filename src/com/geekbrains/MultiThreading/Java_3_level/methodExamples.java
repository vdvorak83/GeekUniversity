package com.geekbrains.MultiThreading.Java_3_level;

import java.io.*;
import java.util.HashMap;

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

    public void addRecordsToFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()){
            file.createNewFile();
        } else file.delete();file.createNewFile();

        FileWriter fileWriter = new FileWriter(file);

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(20);
                    addRecord(fileWriter, "First thread, record: " + i + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(20);
                    addRecord(fileWriter, "Second thread, record: " + i + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(20);
                    addRecord(fileWriter, "Third thread, record: " + i + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private synchronized void addRecord(FileWriter fileWriter,String text) throws IOException {
        fileWriter.write(text);
        fileWriter.flush();
    }
}
