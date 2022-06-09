package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main<T extends Comparable<T>> {

    public static void main(String[] args) {

        int length1 = 100;
        int length2 = 500;
        int length3 = 1000;

        int numOfGroups = 10;
        CountDownLatch latch = new CountDownLatch(numOfGroups);
        Integer[] arr1 = new Integer[length1];
        Integer[] arr2 = new Integer[length2];
        Integer[] arr3 = new Integer[length3];

        Random randNum = new Random();


        for (int i = 0; i < length1; i++) {
            arr1[i] = randNum.nextInt(2000);
        }

        ShellSort sort1 = new ShellSort<>(arr1);
        sort1.sort();

        for (int i = 0; i < length2; i++) {
            arr2[i] = randNum.nextInt(2000);
        }

        ShellSort sort2 = new ShellSort<>(arr2);
        sort2.sort();

        for (int i = 0; i < length3; i++) {
            arr3[i] = randNum.nextInt(2000);
        }

        ShellSort sort3 = new ShellSort<>(arr3);
        sort3.sort();

        SortImpl sortImpl = new SortImpl();

        System.out.println("Array 1");
        for (int j : arr1) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println(sortImpl.checkIfSorted(arr1));

        System.out.println("Array 2");
        for (int j : arr2) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println(sortImpl.checkIfSorted(arr2));

        System.out.println("Array 3");
        for (int j : arr3) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println();


        System.out.println(sortImpl.checkIfSorted(arr3));


//        //  Consequensual
//
//        ShellSort shellSort = new ShellSort(arr1);
//
//        long startTime = System.currentTimeMillis();
//
//        shellSort.sort();
//
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//
//        System.out.println("Time");
//
//        System.out.println(elapsedTime);
//
//        // Parallel
//
//        System.out.println("Sorted");
//        SortImpl sort = new SortImpl();
//        Comparable[] result = new Comparable[length1];
//        try {
//            long startTime = System.currentTimeMillis();
//
//            result = sort.parallelShellSortArray(arr1, numOfGroups, latch);
//
//            long stopTime = System.currentTimeMillis();
//            long elapsedTime = stopTime - startTime;
//
//            System.out.println("Time");
//
//            System.out.println(elapsedTime);
//
//            for (Comparable j:result) {
//                System.out.print(j);
//                System.out.print("\t");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println();


    }
}
