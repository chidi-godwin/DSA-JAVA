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
        this.adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        // this.adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(source)  // uncomment this line for undirected graphs
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

    public void dfsIter() {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int node: adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                stack.push(node);

                while (!stack.isEmpty()) {
                    int currentNode = stack.pop();

                    if (!visited.contains(currentNode)) {
                        visited.add(currentNode);
                        System.out.println(currentNode);

                        for (int childNode : adjacencyList.get(currentNode))
                            if (!visited.contains(childNode))
                                stack.push(childNode);
                    }
                }
            }
        }
    }

    public void bfs() {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();

         for (int node: adjacencyList.keySet()) {
             if(!visited.contains(node)) {
                 queue.addLast(node);
                 visited.add(node);

                 while (!queue.isEmpty()) {
                     int currentNode = queue.pollFirst();
                     System.out.println(currentNode);

                     for (int childNode: adjacencyList.get(currentNode))
                         if (!visited.contains(childNode)) {
                             queue.addLast(childNode);
                             visited.add(childNode);
                         }

                 }
             }
         }
    }

}