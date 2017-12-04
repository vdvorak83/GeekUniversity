package com.geekbrains.TestingPackadge;

import java.util.Arrays;
import java.util.List;

public class TestingMethods {

    public Integer[] extractionOfArray(Integer[] array){
        List<Integer> ints = Arrays.asList(array);
        int i = ints.lastIndexOf(4);
        if (i==-1) new RuntimeException("Array not contain number 4");
        List<Integer> subInts = ints.subList(i+1, ints.size());
        return (Integer[]) subInts.toArray();
    }
}
