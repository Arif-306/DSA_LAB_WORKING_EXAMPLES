package com.mycompany.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    String label;
    boolean isVisited;
    Vertex[] neighbours;

    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
    }

    public void addNeighbours(Vertex[] neighbours) {
        this.neighbours = new Vertex[neighbours.length];
        for (int i = 0; i < neighbours.length; i++) {
            this.neighbours[i] = neighbours[i];
        }
    }
}

class Graph {
    private int v;
    Edge[] edgeList;

    public Graph(int v) {
        this.v = v;
    }

    public Vertex createVertex(String label) {
        return new Vertex(label);
    }

    public Edge createEdge(Vertex start, Vertex end) {
        return new Edge(start, end);
    }

    public void createEdgeList(Edge[] edges) {
        edgeList = new Edge[edges.length];
        for (int i = 0; i < edgeList.length; i++) {
            edgeList[i] = edges[i];
        }
    }
}

class Edge {
    Vertex start;
    Vertex end;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }
}

public class Bfs {

    public static void printGraphBF(Queue<Vertex> queue) {
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (!current.isVisited) {
                current.isVisited = true;
                System.out.println(current.label);

                if (current.neighbours != null) {
                    for (Vertex neighbour : current.neighbours) {
                        if (!neighbour.isVisited) {
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Vertex a, b, c, d, e;
        a = graph.createVertex("A");
        b = graph.createVertex("B");
        c = graph.createVertex("C");
        d = graph.createVertex("D");
        e = graph.createVertex("E");

        a.addNeighbours(new Vertex[]{b, d});
        b.addNeighbours(new Vertex[]{a, c});
        c.addNeighbours(new Vertex[]{b});
        d.addNeighbours(new Vertex[]{a, e});
        e.addNeighbours(new Vertex[]{d});

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(a);

        System.out.println("Printing Graph: Breadth-first traversal");
        printGraphBF(queue);
    }
}
