package com.dataStructures.heap;

public class Heap {
    private final int[] heap;
    private int index;

    public Heap(int size) {
        heap = new int[size];
    }

    public void insert(int value) {
        if (isFull()) throw new IllegalStateException("Heap is full");
        // add the value to the next available index in the array
        heap[index] = value;

        // maintain max heap property
        maxHeapifyUp(index);

        // increase index
        index++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");

        // replace the root with the last item in the heap
        var root = heap[0];
        heap[0] = heap[--index];

        /*
          now start from the root and bubble down with swaps till it's at the right place
          while the root index is still within the size of the heap, and it's parent isn't valid, perform  a swap
          a valid parent is one whose value is greater than both it's right and left children
         */
        maxHeapifyDown();

        return root;
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public static void maxHeapify(int[] numbers) {
        /*
            The index of the last parent in the heap is gotten by the formula (length / 2) - 1
            We only need to iterate through the parents nodes as iterating through leaf nodes would be redundant.
            Also bubbling down the nodes into their right position is less complex and more optimal than bubbling up,
            bubbling down requires less recursion
         */
        var startIndex = numbers.length / 2 - 1;
        for (int i = startIndex; i >= 0; i-- )
            maxHeapify(numbers, i);
    }

    private static void maxHeapify(int[] numbers, int index) {
        /*
            recursively modify array of numbers in place to satisfy the heap property.
            this is done by taking the value at index as the parent, locating its two children and
            swapping the parent with the larger of the two. If the parent is larger than both children, then
            the heap property is already satisfied for that node.
         */
        var largerIndex = index;

        var leftChildIndex = index * 2 + 1;
        if (leftChildIndex < numbers.length && numbers[leftChildIndex] > numbers[largerIndex])
            largerIndex = leftChildIndex;

        var rightChildIndex = index * 2 + 2;
        if (rightChildIndex < numbers.length && numbers[rightChildIndex] > numbers[largerIndex])
            largerIndex = rightChildIndex;

        if (index == largerIndex)
            return;

        swap(numbers, index, largerIndex);

        maxHeapify(numbers, largerIndex);
    }

    public boolean isFull() {
        return index == heap.length;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    private void maxHeapifyUp(int index) {
        var parentIndex = getParentIndex(index);
        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(parentIndex);
        }
    }

    private void maxHeapifyDown() {
        int rootIndex = 0;
        while (rootIndex <= index && !isValidParent(rootIndex)) {
            // swap the parent with the larger of it's two children
            var greaterChildIndex = getGreaterChildIndex(rootIndex);
            swap(heap, rootIndex, greaterChildIndex);
            rootIndex = greaterChildIndex;
        }
    }

    private int getGreaterChildIndex(int parentIndex) {
        /*
            Important edge cases to handle in here
             - Check if the parent has left and right children
                - check the left child first because complete trees always go from left to right
                - if the root has no left child then it certainly has no right, return the parentIndex back
                - if the root has a left child but no right, there's nothing to compare it with so just return the left
                - if the root has both left and the right, the do a comparison and return the greatest
         */

        if (hasLeftChild(parentIndex))
            return parentIndex;

        if (hasRightChild(parentIndex))
            return getLeftChildIndex(parentIndex);

        return leftChild(parentIndex) > rightChild(parentIndex) ?
                getLeftChildIndex(parentIndex) : getRightChildIndex(parentIndex);
    }

    private boolean hasLeftChild(int parentIndex) {
        /*
            There is a left child, if the calculated left index fall with the range of the size of the heap
         */
        return getLeftChildIndex(parentIndex) > index;
    }

    private boolean hasRightChild(int parentIndex) {
        /*
            there is a right child if the calculated left index falls within the range of the size of the heap
         */
        return getRightChildIndex(parentIndex) > index;
    }

    private boolean isValidParent(int parentIndex) {
        /*
            - valid if there's not left child
            - make comparison for just left, if there isn't any right child
            - if both children are available, make the comparison between both children
         */
        var root = heap[parentIndex];

        if (!hasLeftChild(parentIndex))
            return true;

        var leftChild = leftChild(parentIndex);

        if (!hasRightChild(parentIndex))
            return root >= leftChild;

        return root >= leftChild && root >= rightChild(parentIndex);
    }

    private int leftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private static void swap(int[] heap, int first, int second) {
        var temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
}
