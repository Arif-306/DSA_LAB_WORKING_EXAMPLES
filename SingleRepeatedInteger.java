

package com.mycompany.singlerepeatedinteger;

public class SingleRepeatedInteger {

    public static void main(String[] args) {
      int[] A = {1,2,3,4,5,2};
      int repeatedNumber = findSingleRepeated(A);
        System.out.println("The repeated number is: " + repeatedNumber);
    }
    public static int findSingleRepeated(int[] A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                if(A[i] == A[j]) {
                    return A[i];
                }
                
            }
        }
        return -1;
    }
}
