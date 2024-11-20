package com.mycompany.stackusinglinkedlist;

class LL {
    
    private Node top;

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void InsertFirst(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    public Node deleteFirst() {
        if (top == null) {
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
        Node temp = top;
        top = top.next;
        return temp;
    }

    public void DisplayList() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class LinkedListStack {
    LL li = new LL();

    public void push(int element) {
        li.InsertFirst(element);
    }

    public Integer pop() {
        LL.Node poppedNode = li.deleteFirst();
        return (poppedNode != null) ? poppedNode.data : null;
    }

    public void displaystack() {
        System.out.println(" ");
        li.DisplayList();
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();
        st.push(50);
        st.push(70);
        st.push(190);
        System.out.println("1. Stack after push operation: ");
        st.displaystack();
        System.out.println("\n2. Stack after pop operation:");
        Integer poppedValue = st.pop();
        if (poppedValue != null) {
            System.out.println("Popped value: " + poppedValue);
        }
        st.displaystack();
    }
}