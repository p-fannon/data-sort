package com.company;

import java.util.List;

public class SelectionSort {
    int select;
    int access;
    public void go(List<Integer> arr, int time) {
        try {
            for (int i = 0; i < arr.size() - 1; i++) {
                int index = i;
                for (int j = i + 1; j < arr.size(); j++) {
                    if (arr.get(j) < arr.get(index)) {
                        //searching for lowest index
                        this.access++;
                        index = j;
                    }
                }
                int smallerNumber = arr.get(index);
                this.access++;
                arr.set(index, arr.get(i));
                this.select++;
                arr.set(i, smallerNumber);
                this.select++;
                System.out.println(arr);
                Thread.sleep(time);
             }
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("It took " + this.select + " swaps to sort this array. The array was accessed " +
            this.access + " times.");
    }
}
