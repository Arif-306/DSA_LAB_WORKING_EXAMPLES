
package com.mycompany.queueusinglinkedlist;
class LinkedList {
    private Node front;
    private Node rear;

    class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insertLast(int new_data) {
        Node new_node = new Node(new_data);
        if (isEmpty()) {
            front = new_node;
            rear = new_node;
        } else {
            rear.next = new_node;
            rear = new_node;
        }
    }

    public int deleteFirst() {
        if (front == null) {
            throw new IllegalStateException("List is empty");
        }

        int temp = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return temp;
    }

    void displayQueue() { 
        System.out.println("=== Displaying elements of the Queue ===");
        Node current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class Queue {
    LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(int new_data) {
        list.insertLast(new_data);
    }

    public int dequeue() {
        return list.deleteFirst();
    }

    void printQueue() {
        list.displayQueue();
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();
    }
}