package com.geekbrains.MultiThreading.Java_3_level;

import java.io.*;

public class MFU {
    int pageSize = 1000;
    private Object printMonitor = new Object();
    private Object scanMonitor = new Object();



    public void printDoc(File file) throws IOException {
        System.out.println("Thread: " + Thread.currentThread().getName() + " send document to print");
        synchronized (printMonitor){
            BufferedReader br = new BufferedReader(new FileReader(file));
            int quantityChars = 0;
            int pageNumber = 0;
            String line;
            while ((line = br.readLine()) != null){
                quantityChars+=line.length();
                if ((int)Math.floor(quantityChars/10)!=0){
                    pageNumber++;
                    System.out.println("Printed: " + pageNumber);
                }
            }
            System.out.println("Thread: " + Thread.currentThread().getName() + " successful printed document");
            System.out.println("------------------------------------------------------------------------------");
        }

    }

    public void scanDoc(){
        System.out.println("Thread: " + Thread.currentThread().getName() + " send document to scan");
        synchronized (scanMonitor){

        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " successful scanned document");
        System.out.println("------------------------------------------------------------------------------");
    }
}
