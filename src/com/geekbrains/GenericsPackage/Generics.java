package com.geekbrains.GenericsPackage;


import java.util.ArrayList;
import java.util.Arrays;

public class Generics<T> {
    private T[] array;

    public Generics(T[] array) {
        this.array = array;
    }

    public void replaceTwoElements(T firstElement, T secondElement) {
        int index1 = Arrays.asList(array).indexOf(firstElement);
        int index2 = Arrays.asList(array).indexOf(secondElement);

        T tempElement = firstElement;

        array[index1] = secondElement;
        array[index2] = tempElement;
    }

    public void replaceTwoElements(int index1, int index2){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (index2 > array.length || index2==array.length){
            throw new RuntimeException("Incorrect index of array");
        }
        if (index1 > array.length || index1==array.length || index1 < 0){
            throw new RuntimeException("Incorrect index of array");
        }
        T tempElement = array[index1];
        array[index1] = array[index2];
        array[index2] = tempElement;
    }

    public void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public ArrayList<T> convertArrayToArrayList(T[] array){
        return new ArrayList<T>(Arrays.asList(array));
    }

}
