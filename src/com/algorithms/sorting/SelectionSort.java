package com.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[] {9, 15, 11, 12, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] numbers) {
       for (int left = 0; left < numbers.length - 1; left++) {
           int minIdx = findMinIdx(left, numbers);
           swap(left, minIdx, numbers);
       }
    }

    private static int findMinIdx(int start, int[] numbers) {
        int min = start;
        for (int i = start + 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[start])
                min = i;
        }
        return min;
    }

    private static void swap(int a, int b, int[] numbers) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
