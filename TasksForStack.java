

package com.mycompany.tasksforstack;
import java.util.Scanner;

// Custom Stack Class Implementation
class MyStack<T> {
    private Object[] stackArray;
    private int size;
    private int top;

    public MyStack(int capacity) {
        stackArray = new Object[capacity];
        size = capacity;
        top = -1;
    }

    // Push method to add an element to the stack
    public void push(T element) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = element;
    }

    // Pop method to remove and return the top element of the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        T element = (T) stackArray[top];
        stackArray[top--] = null; // Clear the reference
        return element;
    }

    // Peek method to return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return (T) stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Method to search for an element and return its index
    public int search(T element) {
        for (int i = top; i >= 0; i--) {
            if (stackArray[i].equals(element)) {
                return i; // Return the index of the element
            }
        }
        return -1; // If element is not found, return -1
    }
}

// Main Class with Stack operations
public class TasksForStack {
    
    // Method to reverse a string using custom stack
    public static String reverseString(String str) {
        MyStack<Character> stack = new MyStack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));  // Push each character into the stack
        }

        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());  // Pop characters from the stack to reverse
        }

        return reversedString.toString();
    }

    // Method to reverse a number using custom stack
    public static int reverseNumber(int num) {
        MyStack<Integer> stack = new MyStack<>(10);  // A stack to hold digits
        while (num > 0) {
            stack.push(num % 10);  // Push the last digit of the number
            num /= 10;  // Remove the last digit
        }

        int reversedNum = 0;
        int placeValue = 1;
        while (!stack.isEmpty()) {
            reversedNum += stack.pop() * placeValue;  // Rebuild the number by popping the stack
            placeValue *= 10;  // Move to the next place value
        }

        return reversedNum;
    }

    // Method to search for an element in the stack and return its position
    public static <T> int searchElement(MyStack<T> stack, T element) {
        return stack.search(element);  // Search the stack for the element
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Reversed String: " + reverseString(str));

        int num = 12345;
        System.out.println("Reversed Number: " + reverseNumber(num));

        // Create a stack and perform operations
        MyStack<Integer> stack = new MyStack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        int elementToSearch = 30;
        System.out.println("Element " + elementToSearch + " is at position: " + searchElement(stack, elementToSearch));

        System.out.println("Top element in stack: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());
    }
}

