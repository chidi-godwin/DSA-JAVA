package com.dataStructures.trees.avlTree;

public class AVLTree {
    private Node root;

    public void insert(int value) {
        root = insert(this.root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        root.height = Math.max(
                height(root.leftChild),
                height(root.rightChild)) + 1;

        root = balance(root);

        return root;
    }
    private Node balance(Node node) {
        if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);
            return rotateRight(node);
        } else if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateLeft(Node root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot ;
    }

    private Node rotateRight(Node root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }


    private int balanceFactor(Node node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private static class Node {
        private final int value;
        private int height;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Value= %d", this.value);
        }
    }
}
