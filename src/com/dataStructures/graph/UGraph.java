package com.dataStructures.graph;

import java.util.*;

public class UGraph {
    private final Map<Integer, ArrayList<Edge>> adjacencyList;

    public UGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);

        adjacencyList.values().forEach(edges -> edges.removeIf(edge -> edge.destination() == vertex));
    }

    /* create vertices if they don't exist */
    public void addEdge(int source, int destination, int weight) {
        this.adjacencyList.computeIfAbsent(source, key -> new ArrayList<>()).add(new Edge(destination, weight));
        this.adjacencyList.computeIfAbsent(destination, key -> new ArrayList<>()).add(new Edge(source, weight));
    }

    public void removeEdge(int source, int destination) {
        this.adjacencyList.computeIfPresent(source, (vertex, edges) -> {
            edges.removeIf(edge -> edge.destination() == destination);
            return edges;
        });
        this.adjacencyList.computeIfPresent(destination, (vertex, edges) -> {
            edges.removeIf(edge -> edge.destination() == source);
            return edges;
        });
    }

    public void print() {
        for (var entry : adjacencyList.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    public int getShortestDistance(int source, int destination) {
        final Map<Integer, Integer> distances = new HashMap<>();

        for (int vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.replace(source, 0); // at this point we have marked the shorted distance at the starting point to 0 and the rest to infiinty

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));

        queue.add(new Edge(source, 0));

        while (!queue.isEmpty()) {
            var currentEdge = queue.poll();
            var currentVertex = currentEdge.destination();

            visited.add(currentVertex);
            for (var neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor.destination())) {
                    int distance = neighbor.weight() + distances.get(currentVertex);

                    if (distance < distances.get(neighbor.destination())) {
                        distances.replace(neighbor.destination(), distance);
                        queue.add(new Edge(neighbor.destination(), distance));
                    }
                }
            }
        }

        return distances.get(destination);
    }


    record Edge(int destination, int weight) {
    }
}
