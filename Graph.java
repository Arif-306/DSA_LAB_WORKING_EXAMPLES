/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graph;

class ArrayQueue {
    private int front, rear, size;
    private int capacity;
    private int[] array;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void enqueue(int item) {
        if (isFull())
            return;
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size = size + 1;
    }

    int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        int item = array[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return item;
    }
}

public class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void addEdge(String start, String end) {
        int startIndex = start.charAt(0) - 'A';
        int endIndex = end.charAt(0) - 'A';
        addEdge(startIndex, endIndex);
    }

    public void breadthFirstTraversal(int startVertex) {
        boolean[] visited = new boolean[vertices];
        ArrayQueue queue = new ArrayQueue(vertices);

        visited[startVertex] = true;
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.dequeue();
            System.out.print((char)(currentVertex + 'A') + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge("A", "B"); 
        graph.addEdge("A", "C"); 
        graph.addEdge("B", "C");
        graph.addEdge("C", "D"); 
        graph.addEdge("D", "E"); 

        System.out.println("Breadth First Traversal starting from vertex 0:");
        graph.breadthFirstTraversal(0);
    }
}
