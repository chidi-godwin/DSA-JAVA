package com.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = new int[] { 9, 15, 11, 12, 7};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > current) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = current;
        }
    }
}
