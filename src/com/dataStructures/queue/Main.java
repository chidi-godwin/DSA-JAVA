package com.dataStructures.queue;

public class Main {
    public static void main(String[] args) {
        var queue = new CircularArrayQueue(5);
        for (int i = 10; i < 60; i+=10)
            queue.enqueue(i);

        System.out.printf("The element at the front of the queue is %d%n", queue.dequeue());
        System.out.printf("The second element on the queue is %d%n", queue.dequeue());

        queue.enqueue(70);
        queue.enqueue(80);
        System.out.println(queue.peek());

        while(!queue.isEmpty())
            System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
