package com.dataStructures.array;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        for (int i =1; i <= 10; i++)
            numbers.insert(i * 10);
        numbers.removeAt(3);
        numbers.insert(110);
        System.out.println(numbers.indexOf(100));
        System.out.println(numbers.indexOf(3));
        System.out.println(numbers);
        System.out.println(numbers.length());
    }

}
