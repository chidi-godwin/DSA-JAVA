package com.dataStructures.queue;

import java.util.Arrays;

public class CircularArrayQueue {
    private final int[] items;
    private int rear = 0;
    private int front = 0;
    private int count = 0;


    public CircularArrayQueue(int size) {
        items = new int[5];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException("The Queue is full");

        items[rear] = item;
        rear = ++rear % items.length;
        count++;
    }

    public int dequeue() {
        var item = items[front];
        items[front] = 0;

        front = ++front % items.length;
        count--;
        return item;
    }

    public int peek() {
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
