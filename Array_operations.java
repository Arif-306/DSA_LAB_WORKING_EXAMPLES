

package com.mycompany.array_operations;

import java.util.Arrays;
import java.util.Scanner;

public class Array_operations {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
     

     int[] arr = new int[5];
        System.out.println("Initial Array : " + Arrays.toString(arr));
  
        System.out.println("Adding element to the array:");
        for(int i = 0; i<arr.length; i++) {
            System.out.println("Enter Element for index" + i + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Array after adding elements: " + Arrays.toString(arr));
        

        System.out.println("\nEnter the index to edit (0-4):");
        int editindex = scanner.nextInt();
    System.out.println("Enter new value for index " + editindex + ": ");
    int newValue = scanner.nextInt();
    arr[editindex] = newValue;
        System.out.println("Array after editing: " + Arrays.toString(arr));
       
        System.out.println("\nEnter the index to delete (0-4): ");
        int deleteIndex = scanner.nextInt();
        arr[deleteIndex] = 0;
        System.out.println("Array after deletion: " + Arrays.toString(arr));
    }
    
}
