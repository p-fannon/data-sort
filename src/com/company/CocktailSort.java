package com.company;

import java.util.List;

public class CocktailSort {
    int shaken;
    int access;
    public void go(List<Integer> arr, int time) {
        boolean swapped;
        try {
            do {
                swapped = false;
                for (int i = 0; i <= arr.size() - 2; i++) {
                    this.access++;
                    if (arr.get(i) > arr.get(i + 1)) {
                        // test whether the two elements are in the wrong order
                        int temp = arr.get(i);
                        arr.set(i, arr.get(i + 1));
                        arr.set(i + 1, temp);
                        this.shaken++;
                        swapped = true;
                        System.out.println(arr);
                        Thread.sleep(time);
                    }
                }
                if (!swapped) {
                    // exit the loop if no swaps occurred
                    break;
                }
                swapped = false;
                for (int i = arr.size() - 2; i >= 0; i--) {
                    this.access++;
                    if (arr.get(i) > arr.get(i + 1)) {
                        int temp = arr.get(i);
                        arr.set(i, arr.get(i + 1));
                        arr.set(i + 1, temp);
                        this.shaken++;
                        swapped = true;
                        System.out.println(arr);
                        Thread.sleep(time);
                    }
                }
                // if no elements were swapped, then the list is sorted
            } while (swapped);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("It took " + this.shaken + " swaps to sort this array. The array was accessed " +
        this.access + " times.");
    }
}
