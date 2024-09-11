package com.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = new int[] { 9, 15, 11, 12, 7};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] array) {
        // base case
        if (array.length < 2) return;

        int mid = array.length / 2;
        int left[] = new int[mid];
        int right[] = new int[array.length - mid];

        // load up the left array
        for (int i = 0; i < mid; i++)
            left[i] = array[i];

        // load up the right array
        for (int i = mid; i < array.length; i++)
            right[i - mid] = array[i];

        sort(left);
        sort(right);

        merge(array, left, right);
    }
    public static void merge(int[] array, int[] left, int[] right) {
        // initialize 3 pointers, one for each input array
        int i = 0, j = 0, k = 0;

        // loop through both left and right till either one is exhausted and place the smaller value at the array current index
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }

        // empty whichever of the two still has remnants in the array
        while (i < left.length)
            array[k++] = left[i++];

        while (j < right.length)
            array[k++] = right[j++];
    }
}
