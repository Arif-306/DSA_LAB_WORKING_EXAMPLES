
package com.mycompany.queueusingll;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingLL {

    public static void reverseFirstKElements(Queue<Integer> queue, int K) {
        if (K <= 0 || queue.size() <= 1) {
            return; 
               }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < K && !queue.isEmpty(); i++) {
            stack.push(queue.poll());
            }
        
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
              }
        
        int remainingElements = queue.size() - K;
        for (int i = 0; i < remainingElements; i++) {
            queue.offer(queue.poll());
           }
    }

    
    public static int getMinimum(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return Integer.MAX_VALUE; 
           }
        
        int min = Integer.MAX_VALUE;
        for (Integer element : queue) {
            if (element < min) {
                min = element;
               }
               }
    return min;
       }

    public static void printQueue(Queue<Integer> queue) {
        System.out.println(queue);
           }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        
        System.out.println("Original Queue: ");
        printQueue(queue);
        
        int K = 3;
        reverseFirstKElements(queue, K);     
        System.out.println("Queue after reversing first " + K + " elements: ");
        printQueue(queue);
        int min = getMinimum(queue);
        System.out.println("Minimum element in Queue: " + min);
  }
}
