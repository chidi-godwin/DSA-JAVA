package com.dataStructures.hashmap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String sentence = "we would find the first non repeating character in this string now";
        System.out.println(findFirstNonRepeatingCharacter(sentence));
        System.out.println(findFirstRepeatingCharacter(sentence));
    }

    public static char findFirstNonRepeatingCharacter(String sentence) {
        Map<Character, Integer> letterCount = new java.util.HashMap<>();
        char[] splitLetters = sentence.toCharArray();

        for (char letter: splitLetters)
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);

        for (char letter: splitLetters)
            if (letterCount.get(letter) == 1)
                return letter;

        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatingCharacter(String sentence) {
        Set<Character> charSet = new HashSet<>();

        for (char letter: sentence.toCharArray())
            if (charSet.contains(letter))
                return letter;
            else charSet.add(letter);

        return Character.MIN_VALUE;
    }
}
