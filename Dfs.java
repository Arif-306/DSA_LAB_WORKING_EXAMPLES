package com.mycompany.dfs;

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

class LinkedListStack {
    LinkedList li = new LinkedList();

    public void push(Vertex element) {
        li.insertFirst(element);
    }

    public Vertex pop() {
        return li.deleteFirst();
    }

    public boolean isEmpty() {
        return li.isEmpty();
    }

    public Vertex peek() {
        return li.front != null ? li.front.data : null;
    }

    public void displayStack() {
        System.out.println(" ");
        li.displayList();
    }
}

class LinkedList {
    Node front;
    Node rear;

    static class Node {
        public Vertex data;
        public Node next;

        public Node(Vertex data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insertFirst(Vertex newData) {
        Node newNode = new Node(newData);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
    }

    public Vertex deleteFirst() {
        if (isEmpty()) return null;
        Vertex temp = front.data;
        if (front.next == null) {
            rear = null;
        }
        front = front.next;
        return temp;
    }

    public void displayList() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data.label + " ");
            current = current.next;
        }
        System.out.println();
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

public class Dfs {

    public static void printGraphDF(LinkedListStack stack) {
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            if (!current.isVisited) {
                current.isVisited = true;
                System.out.println(current.label);

                if (current.neighbours != null) {
                    for (int i = current.neighbours.length - 1; i >= 0; i--) {
                        if (!current.neighbours[i].isVisited) {
                            stack.push(current.neighbours[i]);
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

        LinkedListStack stack = new LinkedListStack();
        stack.push(a);

        System.out.println("Printing Graph: Depth-first traversal");
        printGraphDF(stack);
    }
}
