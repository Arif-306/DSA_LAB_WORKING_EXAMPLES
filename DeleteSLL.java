

package com.mycompany.deletesll;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteSLL {
    Node head;

    
    public void deleteList() {
        head = null;
        System.out.println("List deleted successfully.");
    }

  
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteSLL list = new DeleteSLL();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Original List:");
        list.printList();

        list.deleteList();

        System.out.println("After deletion:");
        list.printList();
    }
}