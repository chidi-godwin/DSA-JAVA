package com.dataStructures.hashmap;

import java.util.Arrays;
import java.util.LinkedList;

public class HashMap {

    private static class Entry {

        private final int key;
        private String value;
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("(key=%d, value=%s)", key, value);
        }

    }
    private final int size;

    private final LinkedList<Entry>[] hashTable;

    private int hashFunction(int key) {
        return key % size;
    }

    public HashMap(int size) {
        this.size = size;
        //noinspection unchecked
        hashTable = new LinkedList[this.size];
    }

    public void put(int key, String value) {
        int index = hashFunction(key);
        var entryList = hashTable[index];
        if (entryList == null) {
            entryList = hashTable[index] = new LinkedList<>();
        } else {
            for (var entry : entryList) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }

        }
        entryList.addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hashFunction(key);
        var entryList = hashTable[index];

        if (!(entryList == null)) {
            for (var entry : entryList) {
                if (entry.key == key)
                    return entry.value;
            }
        }

        return null;
    }

    public void remove(int key) {
        int index = hashFunction(key);
        var entryList = hashTable[index];

        if (entryList == null)
            return;

        entryList.removeIf(entry -> entry.key == key);
    }

    @Override
    public String toString() {
        return Arrays.toString(hashTable);
    }

    public static void main(String[] args) {
        var intHashMap = new HashMap(10);
        intHashMap.put(1, "a");
        intHashMap.put(2, "b");
        intHashMap.put(3, "c");

        System.out.println(intHashMap);
        System.out.println(intHashMap.get(2));
        System.out.println(intHashMap.get(3));
        intHashMap.put(12, "L");
        System.out.println(intHashMap);
        System.out.println(intHashMap.get(2));
        System.out.println(intHashMap.get(12));
        System.out.println(intHashMap.get(9));
        intHashMap.remove(12);
        intHashMap.remove(5);
        System.out.println(intHashMap);
    }
}
