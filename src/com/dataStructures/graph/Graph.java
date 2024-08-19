package com.dataStructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(int value) {
        this.adjacencyList.putIfAbsent(value, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        // verify that source and destination exists
        var sourceNode = this.adjacencyList.get(source);
        if (sourceNode == null)
            throw new IllegalStateException("Source does not exist");
        var destinationNode = this.adjacencyList.get(destination);
        if (destinationNode == null)
            throw new IllegalStateException("Destination does not exist");

        sourceNode.add(destination);
        // destinationNode.add(source)  // uncomment this line for undirected graphs
    }

    public void removeEdge(int source, int destination) {
        var sourceNode = adjacencyList.get(source);

        sourceNode.remove(Integer.valueOf(destination));
    }

    public void removeNode(int value) {
        adjacencyList.remove(value);

        for (var destinations: adjacencyList.values())
            destinations.remove(Integer.valueOf(value));
    }

    public void print() {
        for (var key: adjacencyList.keySet()) {
            System.out.println(key + ": " + adjacencyList.get(key));
        }
    }
}
