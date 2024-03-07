package com.dataStructures.queue;

import java.util.Queue;
import java.util.Stack;

public class StackedQueue<E> {
    private final Stack<E> inputQueue = new Stack<>();
    private final Stack<E> outputQueue = new Stack<>();

    private void loadOutputQueue() {
        while (!inputQueue.isEmpty())
            outputQueue.push(inputQueue.pop());
    }
    public E dequeue() {
        if (outputQueue.isEmpty())
            loadOutputQueue();

        if (outputQueue.isEmpty())
            throw new IllegalStateException("The queue is empty");

        return outputQueue.pop();
    }

    public void enqueue(E item) {
        inputQueue.push(item);
    }

    public E peek() {
        if (outputQueue.isEmpty())
            loadOutputQueue();

        return outputQueue.peek();
    }

    public boolean isEmpty() {
        return inputQueue.isEmpty() && outputQueue.isEmpty(); 
    }

}
