package com.dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList<Integer>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.removeLast();
        list.removeLast();
        System.out.println(list.getKthFromEnd(1));
        System.out.println(list);
        System.out.println(list.size());

        var doublyList = new DoublyLinkedList<Integer>();
        for (int i = 50; i >= 10; i -= 10)
            doublyList.addAtHead(i);
        for (int i = 60; i <= 100; i += 10)
            doublyList.addAtTail(i);

        doublyList.removeFromHead();
        doublyList.removeFromTail();

        System.out.println(doublyList.getKthFromEnd(5));
        System.out.println(doublyList);
        System.out.println(doublyList.size());
    }
}
