package com.algorithms.searching;

public class JumpSearch {
    public static void main(String[] args) {
        int[] numbers = new int[] { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30};
        for (int num: numbers)
            System.out.println(search(numbers, num));
    }

    public static int search(int[] array, int target) {
        int blockSize = (int) (Math.sqrt(array.length));
        int blockEnd, previousBlock = 0, nextBlock = 0, n = array.length;

        // we calculate the index by removing one from the start of the next block, but this number could also go higher
        // than the size of the array itself, so we always make sure to default it to the last element in the array if it's
        // above it's limit

        do {
            previousBlock = nextBlock;
            nextBlock += blockSize;
            blockEnd = array[Math.min(nextBlock, n) - 1];

            if (previousBlock >= n) return -1;
        } while (blockEnd < target);


        for (int i = previousBlock; i < Math.min(nextBlock, n); i++)
            if (array[i] == target)
                return i;

        return -1;
    }
}
