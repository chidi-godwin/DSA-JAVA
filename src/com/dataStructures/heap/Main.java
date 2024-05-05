package com.dataStructures.heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var maxHeap = new Heap(10);
        maxHeap.insert(10);
        maxHeap.insert(5);;
        maxHeap.insert(17);
        System.out.println(maxHeap.remove());

        int[] numbers = {4, 6, 8, 2 , 0, 9};
        Heap.maxHeapify(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
