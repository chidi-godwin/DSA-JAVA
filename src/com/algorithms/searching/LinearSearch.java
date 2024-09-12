package com.algorithms.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = new int[] {4, 6, 8, 2, 4, 9, 1};
        int[] targets = new int[] {7, 8};

        for (int target: targets)
            System.out.println(search(numbers, target));
    }
    public static int search (int[] array, int target) {

        for (int i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }
}
