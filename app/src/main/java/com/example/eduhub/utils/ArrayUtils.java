package com.example.eduhub.utils;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayUtils {
    public static int[][] generateNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 19; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> array3 = new ArrayList<>();

        
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 3 == 0) {
                array1.add(numbers.get(i));
            } else if (i % 3 == 1) {
                array2.add(numbers.get(i));
            } else {
                array3.add(numbers.get(i));
            }
        }

        
        int[] arr1 = array1.stream().mapToInt(Integer::intValue).toArray();
        int[] arr2 = array2.stream().mapToInt(Integer::intValue).toArray();
        int[] arr3 = array3.stream().mapToInt(Integer::intValue).toArray();

        
        return new int[][] { arr1, arr2, arr3 };
    }
}