package com.dataStructures.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count = 0;

    public static void main(String[] args) {
        var pq = new PriorityQueue();
        pq.add(5);
        pq.add(3);
        pq.add(6);
        pq.add(1 );
        pq.add(17);
        pq.add(12);
        pq.add(14);
        System.out.println(pq);
    }

    private void resizeQueue() {
        int newSize = items.length + items.length / 2;
        var newItems = new int[newSize];
        newItems = Arrays.copyOf(items, newSize);
        items = newItems;
    }

    private int shitItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >=  0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }

        return i + 1;
    }

    public void add(int item) {
        if (count == items.length)
            resizeQueue();


        var index = shitItemsToInsert(item);
        items[index ] = item;
        count++;
    }

    public int remove() {
        if (count == 0)
            throw new IllegalStateException("Queue is Empty");

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
