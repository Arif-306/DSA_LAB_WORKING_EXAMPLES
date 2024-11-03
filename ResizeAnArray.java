

package com.mycompany.resizeanarray;

import java.util.Arrays;
public class ResizeAnArray {

    public static void main(String[] args) {
        int[] originalArray ={2,3,5,9,7,4};
        System.out.println("Original Array: " +Arrays.toString(originalArray));
        
        int newSize = 10;
        int[] resizedArray = resizeArray(originalArray, newSize);
        System.out.println("Resized Array: " + Arrays.toString(resizedArray));
        
    }
    
    public static int[] resizeArray(int[] arr, int newSize) {
        int[] newArray = new int[newSize];
        for(int i = 0;i < arr.length && i < newSize; i++) {
        newArray[i] = arr[i];
    }
        return newArray;
    }
}
