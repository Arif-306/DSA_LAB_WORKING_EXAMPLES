
package com.mycompany.middlenodeofsll;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
        
    }
}

public class MiddleNodeOfSLL {
 Node head;
 
 public void printMiddle() {
     if (head == null) {
         System.out.println("List is empty");
         return;
     }
     Node slow = head;
     Node fast = head;
     
     while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
     }
     System.out.println("Middle node data: " + slow.data);
 }
 
 public void add(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         head = newNode;
     }else{
     Node current = head;
     while (current.next != null) {
         current = current.next;
        }
     current.next = newNode;
     }
 }
 
 
    public static void main(String[] args) {
        MiddleNodeOfSLL list = new MiddleNodeOfSLL();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        
        list.printMiddle();
    }
}
