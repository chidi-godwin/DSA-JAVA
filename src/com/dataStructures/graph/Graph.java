package com.dataStructures.graph;

import java.util.*;

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

    public void dfs() {
        Set<Integer> visited = new HashSet<>();
        for (int node: adjacencyList.keySet())
            if (!visited.contains(node))
                dfs(node, visited);
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.println(node);

        for (int neighbor: adjacencyList.get(node)) {
            if (!visited.contains(neighbor))
                dfs(neighbor, visited);
        }
    }
}
