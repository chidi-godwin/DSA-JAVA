package com.algorithms.searching;

public class TernarySearch {
    public static void main(String[] args) {
        int[] numbers = new int[] { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30};
        for (int num: numbers)
            System.out.println(search(numbers, num));
    }
    public static int search(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            int middle1 = array[mid1], middle2 = array[mid2];

            if (middle1 == target)
                return mid1;
            if (middle2 == target)
                return mid2;

            if (target < middle1)
                right = mid1 - 1;
            else if (target > middle2)
                left = mid2 + 1;
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1;
    }

    public static int searchR(int[] array, int target) {
        return searchR(array, target, 0, array.length - 1);
    }

    private static int searchR(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right -left) / 3;

        int middle1 = array[mid1], middle2 = array[mid2];

        if (target == middle1)
            return mid1;
        if (target == middle2)
            return mid2;

        if (target < middle1)
            return searchR(array, target, left, mid1 - 1);
        else if (target > middle2)
            return searchR(array, target, mid2 + 1, right);

        return searchR(array, target, mid1 + 1, mid2 - 1);
    }
}
