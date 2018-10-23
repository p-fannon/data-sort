package com.company;

import java.util.List;

public class QuickSort {
    private int quickie;
    private int access;
    private int wait;
    public void go(List<Integer> arr, int time) {
        int low = 0;
        int high = arr.size() - 1;
        this.wait = time;
        quickSort(arr, low, high);
        System.out.println("It took " + this.quickie + " swaps to sort this array. The array was accessed " +
                this.access + " times.");
    }
    public void quickSort(List<Integer> arr, int low, int high) {
        if (arr.size() == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        // get the pivot element from middle of list
        int middle = low + (high - low) / 2;
        int pivot = arr.get(middle);
        // make left < pivot and right > pivot
        int i=low, j=high;
        while (i <= j) {
            // Check until all values on left side array are lower than pivot
            while (arr.get(i) < pivot) {
                i++;
                this.access++;
            }
            // Check until all values on left side array are greater than pivot
            while (arr.get(j) > pivot) {
                j--;
                this.access++;
            }
            // Now compare values from both side of lists to see if they need swapping
            // After swapping move the iterator on both lists
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }
    public void swap(List<Integer> arr, int x, int y) {
        try {
            int temp = arr.get(x);
            arr.set(x, arr.get(y));
            arr.set(y, temp);
            quickie++;
            System.out.println(arr);
            Thread.sleep(wait);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
