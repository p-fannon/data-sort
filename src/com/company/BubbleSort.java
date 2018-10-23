package com.company;

import java.util.List;

class BubbleSort {
    void go(List<Integer> arr, int time) {
        int n = arr.size();
        int temp;
        int swap = 0;
        int access = 0;
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n-i); j++) {
                    access++;
                    if (arr.get(j-1) > arr.get(j)) {
                        //do the swap
                        temp = arr.get(j-1);
                        arr.set(j-1, arr.get(j));
                        arr.set(j, temp);
                        System.out.println(arr);
                        swap++;
                        Thread.sleep(time);
                    }
                }
            }
            System.out.println("It took " + swap + " swaps to sort this array. The array was accessed " + access + " times.");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }
}
