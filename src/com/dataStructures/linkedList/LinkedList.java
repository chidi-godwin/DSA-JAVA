package com.dataStructures.linkedList;

import java.util.*;

public class LinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(E value) {
        var node = new Node<E>(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;

    }

    public void addLast(E value) {
        var node = new Node<E>(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;

        size--;
    }

    private Node<E> getPrevious(Node<E> node) {
        if (node == null)
            return null;

        Node<E> previous = null;
        var last = first;


        while (last != node) {
            previous = last;
            last = last.next;
        }

        return previous;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        var previous = getPrevious(last);

        if (previous == null) {
            first = last = null;
            return;
        }

        previous.next = null;
        last = previous;

        size--;
    }

    public E getKthFromEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException("List is empty");

        var start = first;
        var end = first;


        for (int i = 0; i < k - 1; i++)
            start = start.next;

        while(start != last) {
            start = start.next;
            end = end.next;
        }

        return end.value;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public int indexOf(E value) {
        var index = 0;
        var currentNode = first;

        while (currentNode != null) {
            if (Objects.equals(currentNode.value, value))
                return index;
            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public void reverse() {
        if (isEmpty())
            return;

        Node<E> previous = null;
        var current = first;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        first = previous;
    }

    public E[] toArray() {
        var array = new ArrayList<E>();
        array.ensureCapacity(size);
        var current = first;

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
        return new LinkedListIterator();
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }
    }
}
