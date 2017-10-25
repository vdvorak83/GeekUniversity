package com.geekbrains.MultiThreading;

import java.util.Arrays;

public class MultiThreadingCalculate {

    static final int size = 10_000_000;
    static final int h = size / 2;

    public  void oneThreadCalculate(){
        new Thread(() -> System.out.println("One Thread finished by " + calculateArrayValue(createArray(),0,size,0) + " seconds")).start();
    }

    public void twoThreadsCalculate(){
        new Thread(() -> System.out.println("Two Threads finished by " + calculateArrayValueMultiThreading(createArray()) + " seconds")).start();
    }

    private float[] createArray(){
        float[] floats = new float[size];
        Arrays.fill(floats,1);
        return floats;
    }

    private  long calculateArrayValue(float[] array,int beginIndex,int endIndex,int offset){
        long begin = System.currentTimeMillis();
        for (int i = beginIndex; i < endIndex; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();

        long result = (end - begin) / 1000;
        System.out.println(Thread.currentThread().getName() + " seconds: " + result);
        return result;
    }

    private long calculateArrayValueMultiThreading(float[] array){

        float[] firstHalfArray = new float[h];
        float[] secondHalfArray = new float[h];

        long beginDevCalcArray = System.currentTimeMillis();

        System.arraycopy(array, 0, firstHalfArray, 0, h);
        System.arraycopy(array, h, secondHalfArray, 0, h);

        Thread thread_1 = new Thread(() -> calculateArrayValue(firstHalfArray,0,h,0));
        Thread thread_2 = new Thread(() -> calculateArrayValue(secondHalfArray,0,h,h));

        thread_1.start();
        thread_2.start();

        try {
            thread_1.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalfArray, 0, array, 0, h);
        System.arraycopy(secondHalfArray, 0, array, h, h);

        long endDevCalcArray = System.currentTimeMillis();

        return (endDevCalcArray - beginDevCalcArray)/1000;
    }
}
