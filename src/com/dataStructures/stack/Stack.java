package com.dataStructures.stack;

import java.util.LinkedList;

public class Stack<E> {
    private final LinkedList<E> list = new LinkedList<>();

    public void push(E value) {
        list.addLast(value);
    }

    public E pop() {
        return list.removeLast();
    }

    public E peek() {
        return list.peekLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
