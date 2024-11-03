

package com.mycompany.minvalue_array;

public class MinValue_Array {

    public static void main(String[] args) {
     int[] arr = {5,8,9,6,9};
     int minValue = findMinimum(arr);
        System.out.println("Minimum value in the array:" + minValue);
        
    }
    
    public static int findMinimum(int[] arr) {
        int min = arr[0];
         
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
    
    return min;
    }
}