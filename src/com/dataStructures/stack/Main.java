package com.dataStructures.stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter a word of your choice: ");
        var word = scanner.nextLine();
        var reversedWord = StringReverser.reverse(word);

        System.out.println("Reversed Word: " + reversedWord);
        var expression = new Expression("");

        var patterns = new String[]{
            "{[()<>]} true", "{[(<>)} false", "{[()><]} false", "Hello,world! true", " true", "([ false"
        };

        for (var pattern: patterns) {
            var split = pattern.split(" ");
            expression.setExpression(split[0]);
            System.out.println(expression.getExpression() + " " + expression.isBalanced() + " " + split[1]);
        }
    }
}
