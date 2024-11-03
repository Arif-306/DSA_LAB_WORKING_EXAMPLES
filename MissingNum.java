
package com.mycompany.missingnum;

public class MissingNum {

    public static void main(String[] args) {
        int[] a = {54, 55, 57,58, 59, 60};  

        int missingNumber = findMissingNumber(a);
        System.out.println("Missing number is: " + missingNumber);
    }

    public static int findMissingNumber(int[] a) {
        
        int min = a[0];
        int max = a[a.length - 1];
        
        int expectedSum = (max * (max + 1) / 2) - ((min - 1) * min / 2);

     
        int actualSum = 0;
        for (int num : a) {
            actualSum += num;
        }

 
        return expectedSum - actualSum;
    }
}

