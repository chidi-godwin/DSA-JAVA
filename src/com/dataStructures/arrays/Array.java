package com.dataStructures.arrays;

import java.util.Arrays;

public class Array {
    private int size;
    private int lastIndex = 0;
    int [] numbers;
    public Array(int size) {
        this.size = size;
        this.numbers = new int[size];
    }

    private void increaseArraySize() {
        // increase the value of size
        size *= 2;

        // create new array with the new size
        int[] newArray = new int[size];

        // loop through the previous array and copy items
        for (int i = 0; i < numbers.length; i++)
            newArray[i] = numbers[i];

        numbers = newArray;
    }

    public void insert(int number) {

        if (lastIndex >= size) {
            increaseArraySize();
        }

        numbers[lastIndex++] = number;

        return;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= lastIndex) {
            return;
        }

        numbers[index] = 0;

        for (int i = index + 1; i < lastIndex; i++) {
            numbers[i - 1] = numbers[i];
        }

        lastIndex--;

        return;
    }

    public int indexOf(int number) {
        for (int i = 0; i < lastIndex; i++) {
            if (numbers[i] == number)
                return i;
        }

        return -1;
    }

    public int length() {
        return lastIndex;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
