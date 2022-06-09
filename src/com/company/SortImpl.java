package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SortImpl<T extends Comparable<T>> {

    public boolean checkIfSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i].compareTo(arr[i-1]) < 0)
            {
                return false;
            }
        }
        return true;
    }

    public List<T[]> divideInitialArray(T[] array, int pieces) {
        List<T[]> dividedList = new ArrayList<>();

        int parts = array.length / pieces;

        int start = 0;
        int end = parts;

        for (int i = 1; i < pieces; i++) {
            dividedList.add(Arrays.copyOfRange(array, start, end));
            start += parts;
            end += parts;
        }
        dividedList.add(Arrays.copyOfRange(array, start, array.length));
        return dividedList;
    }

    public T[] mergeTwo(T[] arr1, T[] arr2) {
        int i = 0, j = 0, k = 0;

        T[] merged = (T[]) new Comparable[arr1.length + arr2.length];

        // Traverse both array
        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i].compareTo(arr2[j]) < 0)
                merged[k++] = arr1[i++];
            else
                merged[k++] = arr2[j++];
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public T[] mergeSplitedArrays(List<T[]> arr) {
        T[] arrayFirst = arr.get(0);
        for (int i = 1; i < arr.size(); i++)
        {
            arrayFirst = mergeTwo(arrayFirst, arr.get(i));
        }

        return arrayFirst;
    }

    public T[] parallelShellSortArray(T[] array, int pieces, CountDownLatch latch) throws InterruptedException {
        List<T[]> listOfDivided = divideInitialArray(array, pieces);

        for (T[] arr:listOfDivided) {
            Thread thread = new Thread(new RunConcurrentSort<>(latch, arr));
            thread.start();
        }

        latch.await();

        return mergeSplitedArrays(listOfDivided);
    }
}
