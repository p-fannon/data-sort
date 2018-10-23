package com.company;

import java.util.List;

public class InsertionSort {
    void go(List<Integer> arr, int time) {
        int n = arr.size();
        int insert = 0;
        int access = 0;
        try {
            for (int j = 1; j < n; j++) {
                int key = arr.get(j);
                int i = j - 1;
                while((i > -1) && (arr.get(i) > key)) {
                    arr.set(i+1, arr.get(i));
                    i--;
                    access++;
                }
                arr.set(i+1, key);
                insert++;
                access++;
                System.out.println(arr);
                Thread.sleep(time);
            }
            System.out.println("It took " + insert + " inserts to sort this array. The array was accessed " + access + " times.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
