package com.dataStructures.linkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList<Integer>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        System.out.println(list.getKthFromEnd(3));
        System.out.println(list);
    }
}
