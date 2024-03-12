package com.dataStructures.hashmap;

import java.util.Arrays;
import java.util.LinkedList;

public class HashMap {

    private final int size;
    private final LinkedList<Entry>[] hashTable;

    public HashMap(int size) {
        this.size = size;
        //noinspection unchecked
        hashTable = new LinkedList[this.size];
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

    private int hashFunction(int key) {
        return key % size;
    }

    private LinkedList<Entry> getEntryList(int key) {
        var index = hashFunction(key);
        return hashTable[index];
    }

    private LinkedList<Entry> createEntryList(int key) {
        var index = hashFunction(key);
        return hashTable[index] = new LinkedList<>();
    }

    private Entry getEntry(int key) {
        var entryList = getEntryList(key);

        if (entryList != null) {
            for (var entry : entryList) {
                if (entry.key == key)
                    return entry;
            }
        }

        return null;
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        var entryList = getEntryList(key);

        if (entryList == null)
            entryList = createEntryList(key);

        entryList.addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);

        if (entry != null)
            return entry.value;

        return null;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry != null)
            getEntryList(key).remove(entry);
    }

    @Override
    public String toString() {
        return Arrays.toString(hashTable);
    }

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
}
