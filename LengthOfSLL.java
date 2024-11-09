

package com.mycompany.lengthofsll;

class Node {
    int data; // Ye wo value hai jo hum node mein store karte hain.
    Node next;// Ye reference hai jo agle node ko point karta hai.
    
    
    // Constructor, jab hum new node create karte hain to ye data aur next ko set karta hai.
    Node(int data) {
        this.data = data;
        this.next = null; // Jab node banegi, toh initially next null hoga.
    }
}

class LinkedList {
    Node head;// Head pointer jo linked list ke start ko point karta hai.
    
    
     // Constructor, jab linked list create karte hain toh initially list empty hoti hai.
   LinkedList() {
       head = null;
   }
   
    // Function jo ek nayi node ko list ke end mein add karta hai.
   void addNode(int data) {
       Node newNode = new Node(data);// Naye node ko create karte hain.

       
        // Agar list khali hai, yani head null hai, toh new node ko head bana denge.
       if (head == null) {
           head = newNode;
       } else {
           // Agar list mein pehle se nodes hain, toh hum list ke last tak ja kar node ko add karte hain.
           Node current = head;
           while (current.next != null) { // Jab tak next null na ho jaye, current ko move karte raho
               current = current.next;
           }
           current.next = newNode;// End mein new node ko add kar do.
       }
   }
   
    // Function jo linked list ki length calculate karta hai.
   int getLength() {
       int length = 0; // Initial length 0 hoti hai.
       Node current = head;// Head se start karte hain.
       while (current != null) {
           length++; // Hum list ke end tak ja kar har node ko count karte hain.
           current = current.next;// Next node ki taraf move karte hain.
       }
       return length;// Total length return karte hain.
   }
   public void printlist() {
       Node current = head;
       while (current != null) {
           System.out.println(current.data);
           current = current.next;
       }
   }
}


public class LengthOfSLL {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();// Nayi linked list create karte hain.
        
          // List mein kuch nodes add karte hain.
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        
        list.printlist();//print ke function ko call krte ha takke hm node ko sb alag alag lines main likh sake 
         // Linked list ki length calculate karte hain aur print karte hain.
        System.out.println("Length of linked list: " + list.getLength());
    }
}

