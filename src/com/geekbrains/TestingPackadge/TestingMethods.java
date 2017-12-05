package com.geekbrains.TestingPackadge;

import java.util.Arrays;
import java.util.List;

public class TestingMethods {

    public Integer[] extractionOfArray(Integer[] array){
        List<Integer> ints = Arrays.asList(array);
        int i = ints.lastIndexOf(4);
        if (i==-1)throw new RuntimeException("Array not contain number 4");
        List<Integer> subInts = ints.subList(i+1, ints.size());
        return subInts.toArray(new Integer[0]);
    }
    public boolean containsNumbers(Integer[] arrray, Integer[] insertArray){
        List<Integer> ints = Arrays.asList(arrray);
        if (ints.containsAll(Arrays.asList(insertArray))) return true;
        return false;
    }
}
