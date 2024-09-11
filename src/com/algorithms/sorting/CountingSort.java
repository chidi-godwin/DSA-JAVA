package com.algorithms.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] numbers = new int[] {4, 2, 2, 8, 3, 3, 1};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;

        // get the max element in the array
        int max = Arrays.stream(array).max().getAsInt();

        // create and populate cumulative frequency array
        int[] cumFreq = new int[max + 1];
        for (int num: array)
            cumFreq[num]++;
        for (int i = 1; i < cumFreq.length; i++)
            cumFreq[i] += cumFreq[i - 1];

        // sort data into output array of same size with input
        // loop a
        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            int numCumFreq = cumFreq[num]--; // the num frequency now indicates the position for it's number with the cum sum
            output[numCumFreq - 1] = num;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
}
