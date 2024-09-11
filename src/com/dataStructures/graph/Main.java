package com.dataStructures.graph;

import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {
        final UGraph ugraph = new UGraph();
        ugraph.addEdge(1, 2, 3);
        ugraph.addEdge(1, 4, 2);
        ugraph.addEdge(1, 3, 4);
        ugraph.addEdge(2, 4, 6);
        ugraph.addEdge(3, 4, 1);
        ugraph.addEdge(2, 5, 1);
        ugraph.addEdge(4, 5, 5);

        int shortestDistance = ugraph.getShortestDistance(1, 5);
        System.out.println(shortestDistance);
    }

    private static void testGraphTraversal(Graph graph) {
        System.out.println();
        graph.dfs();
        System.out.println();

        System.out.println();
        graph.dfsIter();
        System.out.println();

        System.out.println();
        graph.bfs();
        System.out.println();
    }

    @NotNull
    private static Graph getGraph() {
        final Graph graph = new Graph();

        graph.addNode(7);
        graph.addNode(5);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(9);

        graph.addEdge(7, 3);
        graph.addEdge(7, 5);

        graph.addEdge(5, 7);
        graph.addEdge(5, 2);
        graph.addEdge(5, 9);

        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);

        graph.addEdge(3, 2);
        graph.addEdge(3, 7);

        graph.addEdge(9, 2);
        graph.addEdge(9, 7);
        graph.addEdge(9, 5);
        return graph;
    }

}
