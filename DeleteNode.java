
package com.mycompany.deletenode;


class Node {
    int data;    
    Node next;   
    
    public Node(int data) {
        this.data = data; 
        this.next = null;  
       }
    }

class LinkedList {
    Node head;   

    public LinkedList() {
        head = null;  
        }

    
    public void append(int data) {
        Node newNode = new Node(data);  
        if (head == null) {
            head = newNode;  
        } else   {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;  
           }
       }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
           }

        if (position == 1) {
            head = head.next;  
            return;
           }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
             }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position.");
            return;
             }
        temp.next = temp.next.next; 
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
   
 }
   }

public class DeleteNode {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();  

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        
        System.out.println("Original List:");
        list.display(); 
   
        list.deleteAtPosition(3);
        
        System.out.println("List after deleting node at position 3:");
        list.display(); 

        list.deleteAtPosition(1);
        
        System.out.println("List after deleting node at position 1:");
        list.display();  

        list.deleteAtPosition(10); 
    }
}

