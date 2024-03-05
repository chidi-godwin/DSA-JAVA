package com.dataStructures.linkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList<Integer>();
        list.addLast(10);
        list.addLast(30);
        list.addFirst(10);

        System.out.println(list);
    }
}
