package com.dataStructures.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

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

        System.out.println();
        graph.dfs();
        System.out.println();

        graph.print();

        graph.removeEdge(5, 9);
        System.out.println("remove edge 9 from 5");
        graph.print();

        System.out.println("remove node 9");
        graph.removeNode(9);
        graph.print();

    }
}
