
package com.mycompany.removeduplicatesortedsll;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
               
    }
}

public class RemoveDuplicateSortedSLL {
     Node head;
     
     public void removeDuplicate() {
         Node current = head;
         
         while (current != null && current.next != null) {
             if (current.data == current.next.data) {
                 current.next = current.next.next;
             }else{
                 current = current.next;
             }
         }
     }
     
     public void add(int data){
         Node newNode = new Node(data);
         if(head == null) {
             head = newNode;
         }else{
             Node current = head;
             while(current.next != null) {
                 current = current.next;
             }
             current.next = newNode;
         }
     }
     
     public void printList() {
         Node current = head;
      while ( current != null) {
          System.out.println(current.data + " ");
          current = current.next;
      }
         System.out.println();
     }
    public static void main(String[] args) {
        RemoveDuplicateSortedSLL list = new RemoveDuplicateSortedSLL();
        
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4); 
               
        System.out.println("Original List: ");
        list.printList();
        
        list.removeDuplicate();
        
        System.out.println("List after removing duplicates: ");
        list.printList();
    }
}
