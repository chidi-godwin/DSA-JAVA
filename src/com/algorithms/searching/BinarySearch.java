package com.algorithms.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = new int[] { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30};
        int [] outliers = new int[] {3, 9, 20, 30};
        for (int num: outliers)
            if (searchR(numbers, num) == -1)
                System.out.println(num);
    }

    public static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int middle = array[mid];
            if (middle == target)
                return mid;
            else if(target > middle)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static int searchR(int[] array, int target) {
        return searchR(array, target, 0, array.length - 1);
    }
    private static int searchR(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        if (array[mid] == target)
            return mid;

        if (array[mid] < target)
            return searchR(array, target, mid + 1, right);
        else
            return searchR(array, target, left, mid - 1);
    }
}
