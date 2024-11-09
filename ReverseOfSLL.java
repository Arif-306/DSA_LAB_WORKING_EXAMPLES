package com.mycompany.reverseofsll;



class Node  {
     int data;
     Node next;
     
     Node(int data) {
         this.data = data;
         this.next = null;
         
     }
}

  public class ReverseOfSLL {
   Node head;
   
   
   public ReverseOfSLL reverseCopy() {
       Node current = head;
       Node newHead = null;
       
       while (current != null) {
           Node newNode = new Node(current.data);
           newNode.next = newHead;
           newHead = newNode;
           current =  current.next;
          }
       ReverseOfSLL reverseList = new ReverseOfSLL();
       reverseList.head = newHead;
       
       return reverseList;
   }
   
   public void add(int add) {
       Node newNode = new Node(add);
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
   
   public void printList() {
       Node current = head;
       while (current != null) {
           System.out.println(current.data + " ");
           current = current.next;
       }
       System.out.println( );
   }
    public static void main(String[] args) {
        ReverseOfSLL list = new ReverseOfSLL();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
         
        System.out.println("Original List:");
        list.printList();
        
        ReverseOfSLL ReversedList = list.reverseCopy();
        
        System.out.println("Reversed Copy:");
        ReversedList.printList();
    }
}
