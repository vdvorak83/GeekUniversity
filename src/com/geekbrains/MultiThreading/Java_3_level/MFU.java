package com.geekbrains.MultiThreading.Java_3_level;

import java.io.*;

public class MFU {
    private int pageSize = 1000;
    private Object printMonitor = new Object();
    private Object scanMonitor = new Object();

    public MFU(int pageSize) {
        if (pageSize!=0)this.pageSize = pageSize;
    }

    public void printDoc(File file) throws IOException {
        String nameThread = Thread.currentThread().getName();
        System.out.println("Thread: " + nameThread + " send document to print");
        synchronized (printMonitor){
            BufferedReader printFileReader = new BufferedReader(new FileReader(file));
            processDocument(nameThread,printFileReader,"|| Printed page number: ");
            System.out.println("Thread: " + nameThread + " successful printed document");
        }
    }

    public void scanDoc(File file) throws IOException {
        String nameThread = Thread.currentThread().getName();
        System.out.println("Thread: " + nameThread + " send document to scan");
        synchronized (scanMonitor){
            BufferedReader scanFileReader = new BufferedReader(new FileReader(file));
            processDocument(nameThread, scanFileReader, "|| Scanned page number: ");
            System.out.println("Thread: " + nameThread + " successful scanned document");
        }
    }

    private void processDocument(String nameThread, BufferedReader FileReader,String messageChapter) throws IOException {
        int quantityChars = 0;
        int pageNumber = 1;
        System.out.println(nameThread + messageChapter + pageNumber);
        String line;
        while ((line = FileReader.readLine()) != null){
            quantityChars+=line.length();
            if ((int)Math.floor(quantityChars/pageSize)!=0){
                try {
                    Thread.sleep(50);
                    System.out.println(nameThread + messageChapter + pageNumber);
                    pageNumber++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
