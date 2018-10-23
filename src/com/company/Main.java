package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int amount;
    private static int time;
    private static int sort;
    private static String[] selection = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort",
                                "Selection Sort", "Shell Sort", "Cocktail Sort"};

    public static void main(String[] args) {
        // write your code here
        Main theMain = new Main();
        theMain.go();
    }

    private void go() {
        Scanner in = new Scanner(System.in);
        boolean run = true;
        do {
            boolean isValidNumber=false;
            do {
                System.out.println("Choose how many elements (between 3 and 88) you would like to sort:");
                amount = in.nextInt();
                if (amount < 3 || amount > 88) {
                    System.out.println("Choose again!");
                } else {
                    isValidNumber = true;
                }
            } while (!isValidNumber);
            boolean isValidTime = false;
            do {
                System.out.println("How long would you like to delay sorting in milliseconds? Pick '0' for no delay, but no " +
                        "more than 5000:");
                time = in.nextInt();
                if (time < 0 || time > 5000) {
                    System.out.println("Choose again!");
                } else {
                    isValidTime = true;
                }
            } while (!isValidTime);
            boolean isValidSort = false;
            do {
                System.out.println("Pick your sorting algorithm. Here are your options:");
                int option = 1;
                for (String entry : selection) {
                    System.out.print(option + ". ");
                    System.out.println(entry);
                    option++;
                }
                sort = in.nextInt();
                if (sort < 1 || sort > 7) {
                    System.out.println("Choose again!");
                } else {
                    isValidSort = true;
                }
            } while (!isValidSort);
            List<Integer> theArray = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                theArray.add(i + 1);
            }
            Collections.shuffle(theArray);
            System.out.println(theArray);
            System.out.println("This shuffled array with " + amount + " elements will be sorted with " + selection[sort - 1] +
                    " sorting algorithm every " + time + " milliseconds.");
            try {
                Thread.sleep(1000);
                System.out.println("The sort begins in:\n3...");
                Thread.sleep(1000);
                System.out.println("2...");
                Thread.sleep(1000);
                System.out.println("1...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (sort) {
                case 1:
                    BubbleSort theBubble = new BubbleSort();
                    theBubble.go(theArray, time);
                    break;
                case 2:
                    InsertionSort theInsert = new InsertionSort();
                    theInsert.go(theArray, time);
                    break;
                case 3:
                    MergeSort theMerge = new MergeSort();
                    theMerge.go(theArray, time);
                    break;
                case 4:
                    QuickSort theQuick = new QuickSort();
                    theQuick.go(theArray, time);
                    break;
                case 5:
                    SelectionSort theSelect = new SelectionSort();
                    theSelect.go(theArray, time);
                    break;
                case 6:
                    ShellSort theShell = new ShellSort();
                    theShell.go(theArray, time);
                    break;
                case 7:
                    CocktailSort theCocktail = new CocktailSort();
                    theCocktail.go(theArray, time);
                    break;
            }
            boolean isValidAnswer;
            do {
                System.out.println("Sort complete! Try another sort? (y/n)");
                in.nextLine();
                String answer = in.nextLine();
                if (answer.equals("y")) {
                    System.out.println("Let's goooooo!");
                    run = true;
                    isValidAnswer = true;
                } else if (answer.equals("n")) {
                    System.out.println("Goodbye!");
                    run = false;
                    isValidAnswer = true;
                } else {
                    System.out.println("Not a valid answer!");
                    isValidAnswer = false;
                }
            } while (!isValidAnswer);
        } while (run);
    }
}
