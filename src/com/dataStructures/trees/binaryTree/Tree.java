package com.dataStructures.trees.binaryTree;

import org.jetbrains.annotations.NotNull;

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
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(this.root, other.root);
    }

    private boolean equals(Node firstNode, Node secondNode) {
        if (firstNode == null & secondNode == null)
            return true;

        return firstNode != null && secondNode != null && equals(firstNode.leftChild, secondNode.leftChild) && equals(firstNode.rightChild, secondNode.rightChild);
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