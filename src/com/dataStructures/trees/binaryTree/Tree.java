package com.dataStructures.trees.binaryTree;

public class Tree {
    private Node root;

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree has no root node");

        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree has no root node");

        if (isLeaf(root))
            return root.value;

        var left = max(root.leftChild);
        var right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    private boolean isLeaf(Node root) {
        if (root.leftChild == null && root.rightChild == null)
            return true;

        return false;
    }

    private static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
