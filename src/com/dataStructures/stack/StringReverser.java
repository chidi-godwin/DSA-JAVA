package com.dataStructures.stack;

import java.util.Stack;

public class StringReverser {
    public static String reverse(String word) {
        var stack = new Stack<Character>();
        for (var letter: word.toCharArray())
            stack.push(letter);

        StringBuilder reversedWord = new StringBuilder();
        while (!stack.isEmpty())
            reversedWord.append(stack.pop());

        return reversedWord.toString();
    }
}
