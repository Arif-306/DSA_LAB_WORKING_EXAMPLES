

package com.mycompany.reversearray;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
    int[] arr ={8,9,5,7,4,2,3};
        System.out.println("Original Array:");
        printArray(arr);
        
        
        reverseArray(arr);
        System.out.println("Reversed Array:" );
        printArray(arr);
    }
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            
            start++;
            end--;
        }
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
            
    }
        System.out.println();
}
}