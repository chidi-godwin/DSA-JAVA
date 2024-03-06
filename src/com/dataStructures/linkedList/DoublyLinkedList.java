package com.dataStructures.linkedList;

import java.util.*;

public class DoublyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void addAtHead(E value) {
        var node = new Node<E>(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        size++;
    }

    public void addAtTail(E value) {
        var node = new Node<E>(value);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void removeFromHead() {
        if (isEmpty())
            throw new IllegalStateException("List is Empty");

        if (head == tail) {
            head = tail = null;
            return;
        } else {

            var next = head.next;
            next.prev = head.next = null;
            head = next;
        }
        size--;
    }

    public void removeFromTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is Empty");
        }

        if (tail == head) {
            tail = head = null;
        } else {

            var prev = tail.prev;
            prev.next = tail.prev = null;
            tail = prev;
        }
        size--;
    }

    public E getKthFromEnd(int k) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (k > size)
            throw new IllegalArgumentException("Index out of range");

        var end = tail;

        for (int i = 1; i < k; i++)
            end = end.prev;

        return end.value;
    }

    public int indexOf(E value) {
        int index = 0;
        var start = head;

        while (start != null) {
            if (Objects.equals(start.value, value))
                return index;
            start = start.next;
            index++;
        }

        return -1;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return size;
    }

    public void reverse() {
        if (isEmpty())
            return;

        var current = head;
        while (current != null) {
            var prev = current.next;
            current.next = current.prev;
            current.prev = prev;
            current = prev;
        }

        var temp = tail;
        tail = head;
        head = temp;
    }

    public E[] toArray() {
        var array = new ArrayList<E>();
        array.ensureCapacity(size);
        var current = head;

        while (current != null) {
            array.add(current.value);
            current = current.next;
        }

        @SuppressWarnings("unchecked")
        E[] output = (E[]) new Object[size];
        return array.toArray(output);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value) {
            this.value = value;
        }
    }

    private class DoublyLinkedListIterator implements Iterator<E> {
        Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            var value = current.value;
            current = current.next;
            return value;
        }
    }
}
