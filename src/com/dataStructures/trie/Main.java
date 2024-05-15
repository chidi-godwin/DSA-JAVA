package com.dataStructures.trie;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("cat");
        trie.insert("canada");
        System.out.println(trie.contains("cat"));
        System.out.println(trie.contains("can"));
        System.out.println(trie.contains("canada"));
        trie.traverse(Trie.TraverseOrder.Pre);
    }
}
