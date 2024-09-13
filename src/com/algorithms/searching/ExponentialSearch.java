package com.algorithms.searching;

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] numbers = new int[] { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30};
        for (int num: numbers)
            System.out.println(search(numbers, num));
    }

    public static int search(int[] array, int target) {
        int n = array.length;

        if (n == 0)
            return -1;

        if (array[0] == target)
            return 0;

       int bound = 1;
       while (bound < n && array[bound] <= target)
           bound *= 2;

        int left = bound / 2; // takes you to the end of the previous bound
        int right = Math.min(bound, n - 1); // wraps the bound around the end of the array since it can get past it
        return binarySearch(array, target, left, right);
    }

    private static int binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int middle = array[mid];

            if (middle == target)
                return mid;

            if (target < middle)
                right = mid - 1;
            else
                left = mid + 1;

        }

        return -1;
    }
}
