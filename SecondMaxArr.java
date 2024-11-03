

package com.mycompany.secondmaxarr;

public class SecondMaxArr {

    public static void main(String[] args) {
       int[] arr = {5,9,1,7,3,6};
       int secondMaxValue = findSecondMax(arr);
        System.out.println("Second maximum value in the array: " + secondMaxValue );
        
    }
    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
    }
     return secondMax;
    }
}
