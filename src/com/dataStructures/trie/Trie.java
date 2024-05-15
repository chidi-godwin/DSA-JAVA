package com.dataStructures.trie;

import java.util.HashMap;

public class Trie {
    private static class Node {
        private static final int ALPHABET_SIZE = 26;

        private final char value;
        private final HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value  = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        /**
         * The child here refers to the node for the character which should be in the children map for the root node
         * this method is called on
         * @param ch - character in a word
         * @return Node - the node object for the character
         */
        public Node getChild(char ch) {
            return children.get(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (char ch: word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        var current = root;
        for (var ch: word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public enum TraverseOrder {
        Pre, Post
    }

    public void traverse(TraverseOrder order) {
        switch (order) {
            case TraverseOrder.Post -> postOrderTraverse(root);
            case TraverseOrder.Pre -> preOrderTraverse(root);
        }
    }

    private void preOrderTraverse(Node root) {
        System.out.println(root.value);

        for (var child : root.getChildren()) {
            preOrderTraverse(child);
        }
    }

    private void postOrderTraverse(Node root) {
        for (var child: root.getChildren()) {
            postOrderTraverse(child);
        }

        System.out.println(root.value);
    }

    public void remove(String word) {
         if (word == null)
             return;

         remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        // Base Case - The trie always starts with an empty node, explains why we don't have to do word.length() - 1
        if (index == word.length()) {
            root.isEndOfWord = false;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) return; // either we are already at the last letter or the word wasn't found

        // calling the recursion at this time signifies the post order traversal as we would still operate on the child
        // after this
        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(child.value);
    }
}
