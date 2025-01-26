package com.mycompany.mainlinkedlist;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedListOperations {
    ListNode head;
    ListNode tail; // Added to manage tail in the add method.

    // Find length
    public int calculateLength() {
        int length = 0;
        for (ListNode current = head; current != null; current = current.next) {
            length++;
        }
        return length;
    }

    // Find middle node
    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        ListNode slowPointer = head;  // Pointer that moves one step
        ListNode fastPointer = head;  // Pointer that jumps two steps

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slowPointer one step
            fastPointer = fastPointer.next.next; // Move fastPointer two steps
        }
        System.out.println("Middle Node: " + slowPointer.value);
    }

    // Reverse list
    public void reverseList() {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Store next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous to current
            current = nextNode; // Move to next node
        }
        head = previous; // Update head to the new front of the list
    }

    // Remove duplicates
    public void removeDuplicates() {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next; // Skip duplicate
            } else {
                current = current.next; // Move to next node
            }
        }
    }

    // Merge two sorted lists
    public static LinkedListOperations mergeLists(LinkedListOperations list1, LinkedListOperations list2) {
        LinkedListOperations mergedList = new LinkedListOperations();
        ListNode current1 = list1.head;
        ListNode current2 = list2.head;

        while (current1 != null || current2 != null) {
            if (current1 == null) {
                mergedList.addNode(current2.value);
                current2 = current2.next;
            } else if (current2 == null) {
                mergedList.addNode(current1.value);
                current1 = current1.next;
            } else if (current1.value <= current2.value) {
                mergedList.addNode(current1.value);
                current1 = current1.next;
            } else {
                mergedList.addNode(current2.value);
                current2 = current2.next;
            }
        }
        return mergedList;
    }

    // Add node to list
    public void addNode(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = tail = newNode; // Initialize head and tail
        } else {
            tail.next = newNode; // Link new node
            tail = newNode; // Update tail
        }
    }

    // Delete entire list
    public void clearList() {
        head = null; // Clear the head reference
        tail = null; // Clear the tail reference
        System.out.println("List is deleted.");
    }

    // Print list
    public void displayList() {
        ListNode current = head;
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println(); // New line after printing the list
    }
}

public class MainLinkedList {
    public static void main(String[] args) {
        LinkedListOperations list1 = new LinkedListOperations();
        list1.addNode(11);
        list1.addNode(11);
        list1.addNode(21);
        list1.addNode(32);
        list1.addNode(32);
        list1.addNode(43);
        list1.addNode(43);
        list1.addNode(54);
        list1.addNode(65);
        list1.addNode(76);
        list1.addNode(79);

        System.out.println("Original List: ");
        list1.displayList();

        System.out.println("Length of the list: " + list1.calculateLength());

        list1.findMiddle();

        list1.reverseList();
        System.out.println("Reversed List : ");
        list1.displayList();

        list1.removeDuplicates();
        System.out.println("List after removing duplicates: ");
        list1.displayList();

        LinkedListOperations list2 = new LinkedListOperations();
        list2.addNode(87);
        list2.addNode(98);
        list2.addNode(01);
        list2.addNode(32);
        list2.addNode(43);
        list2.addNode(54);
        list1.addNode(55);
        
        
        LinkedListOperations mergedList = LinkedListOperations.mergeLists(list1, list2);
        System.out.println("Merged List:");
        mergedList.displayList();

        list1.clearList();
    }
}