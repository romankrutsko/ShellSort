package com.company;

import java.util.Arrays;

public class GenericArray<T> {

    private Object[] genericArr;

    public GenericArray(int size) {
        genericArr = new Object[size];
    }

    public T get(int index) {
        return (T) genericArr[index];
    }

    public void set(int index, T element) {
        genericArr[index] = element;
    }

    @Override
    public String toString() {
        return Arrays.toString(genericArr);
    }
}
