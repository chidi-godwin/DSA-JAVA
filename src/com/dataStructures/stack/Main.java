package com.dataStructures.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a word of your choice: ");
        var word = scanner.nextLine();
        var reversedWord = StringReverser.reverse(word);

        System.out.println("Reversed Word: " + reversedWord);
    }
}
