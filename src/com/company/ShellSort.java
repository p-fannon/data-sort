package com.company;

import java.util.List;

public class ShellSort {
    private int access;
    private int shell;
    public void go(List<Integer> arr, int time) {
        int inner, outer, temp;
        int h = 1;
        while (h <= arr.size() / 3) {
            h = h * 3 + 1;
        }
        try {
            while (h > 0) {
                for (outer = h; outer < arr.size(); outer++) {
                    temp = arr.get(outer);
                    this.access++;
                    inner = outer;
                    while (inner > h - 1 && arr.get(inner - h) >= temp) {
                        arr.set(inner, arr.get(inner - h));
                        inner -= h;
                        this.access++;
                        this.shell++;
                        System.out.println(arr);
                        Thread.sleep(time);
                    }
                    arr.set(inner, temp);
                    this.shell++;
                    System.out.println(arr);
                    Thread.sleep(time);
                }
                h = (h - 1) / 3;
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("It took " + this.shell + " swaps to sort this array. The array was accessed " +
        this.access + " times.");
    }
}
