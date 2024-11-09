/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mergelistofsll;

class Node{
    int data;
    Node address;
    
    public Node(int data){
        this.data=data;
        this.address=null;
    }
}

public class MergeListOfSLL{
    Node head,tail;
    public MergeListOfSLL(){
        head=tail=null;
    }
    
    public void add(int d){
        Node n = new Node(d);
        if (head==null){
         head=tail=n;   
        }else{
            tail.address=n;
            tail=n;
        }
    }
    
    public void PrintList(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.address;
        }
    }
    
    public static MergeListOfSLL merge(MergeListOfSLL list1, MergeListOfSLL list2){
        MergeListOfSLL mergedList = new MergeListOfSLL();
        Node current1 = list1.head;
        Node current2 = list2.head;
        while(current1!=null && current2!=null){
            if(current1.data<=current2.data){
                mergedList.add(current1.data);
                current1 = current1.address;
            }else{
                    mergedList.add(current2.data);
                    current2 = current2.address;
        }
            }
        // If there are remaining nodes in list1
        while(current1!=null){
            mergedList.add(current1.data);
            current1 = current1.address;
        }
        // If there are remaining nodes in list2
        while (current2 != null){
            mergedList.add(current2.data);
            current2 = current2.address;
        }
        return mergedList;
    }

    
    public static void main(String[] args) {
        MergeListOfSLL SLL = new MergeListOfSLL ();
        SLL.add(1);
        SLL.add(2);
        SLL.add(3);
       
        System.out.println("List 1:");
        SLL.PrintList();
        
        MergeListOfSLL SLL1 = new MergeListOfSLL ();
        SLL1.add(4);
        SLL1.add(5);
        SLL1.add(6);
      
        System.out.println("List 2:");
        SLL.PrintList();
        
        MergeListOfSLL mergedList = MergeListOfSLL.merge(SLL, SLL1); // Merge the two lists
        System.out.println("Merged List:");
        mergedList.PrintList();
        
    }
}