package com.algorithms.sorting;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = new int[] {9, 15, 11, 12, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] array) {
        bucketSort(array, array.length);
    }

    public static void sort(int[] array, int bucketSize) {
        bucketSort(array, bucketSize);
    }

    private static void bucketSort(int[] array, int bucketSize) {
        if (array == null || array.length <= 1) return;

        // create an array of buckets
        List<Integer>[] buckets = new List[bucketSize];
        for (int i = 0; i < bucketSize; i++)
            buckets[i] = new ArrayList<Integer>();

        // get the range of values in the array
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = (((max - min) + 1) / bucketSize) + 1;

        // distribute values into the bucket
        for (int num: array) {
            int index = (num - min) / range;
            buckets[index].add(num);
        }

        // sort each bucket
        for (var bucket: buckets)
            Collections.sort(bucket);

        // arrange each bucket into the input array
        int i = 0;
        for (var bucket: buckets)
            for (int num: bucket)
                array[i++] = num;
    }
}
