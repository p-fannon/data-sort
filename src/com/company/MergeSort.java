package com.company;

import java.util.List;

public class MergeSort {
    private List<Integer> array;
    private int length;
    private int[] tempMergeArr;
    private int access;
    private int merge;
    private int wait;
    void go(List<Integer> arr, int time) {
        this.length = arr.size();
        this.array = arr;
        this.tempMergeArr = new int[length];
        this.wait = time;
        doMergeSort(0, this.length - 1);
        System.out.println("It took " + this.merge + " merges to sort this array. The array was accessed " +
                            this.access + " times.");
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // sort the left side
            doMergeSort(lowerIndex, middle);
            // sort right side
            doMergeSort(middle + 1, higherIndex);
            // merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i=lowerIndex; i <= higherIndex; i++) {
            tempMergeArr[i] = array.get(i);
            this.access++;
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        try {
            while (i <= middle && j <= higherIndex) {
                this.access++;
                if (tempMergeArr[i] <= tempMergeArr[j]) {
                    array.set(k, tempMergeArr[i]);
                    i++;
                    this.merge++;
                    System.out.println(array);
                    Thread.sleep(wait);
                } else {
                    array.set(k, tempMergeArr[j]);
                    j++;
                    this.merge++;
                    System.out.println(array);
                    Thread.sleep(wait);
                }
                k++;
            }
            while (i <= middle) {
                array.set(k, tempMergeArr[i]);
                k++;
                i++;
                this.merge++;
                System.out.println(array);
                Thread.sleep(wait);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
