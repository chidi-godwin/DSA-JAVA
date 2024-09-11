package com.algorithms.sorting;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[] {9, 15, 11, 12, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] numbers) {
        int n = numbers.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i ; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(j, j - 1, numbers);
                    swapCount++;
                }
            }

            if (swapCount == 0)
                break;
        }
    }

    private static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
