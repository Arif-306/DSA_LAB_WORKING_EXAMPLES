

package com.mycompany.findfiverpeatednteger;
import java.util.ArrayList;

public class FindFiveRpeatednteger {

    public static void main(String[] args) {
        int[] B = {1,2,3,4,5,6,3,2,1,4,5,3,5,7,3,9,3};
        ArrayList<Integer> repeatedNumbers = findFiveRepeated(B);
        System.out.println("The repeated number are: " + repeatedNumbers);
      
    }
    public static ArrayList<Integer>findFiveRepeated(int[] B) {
        int[] count = new int[B.length];
        ArrayList<Integer>repeatedNumbers = new ArrayList<>();
        
        
        for (int i = 0; i < B.length;i++) {
            count[B[i]-1]++;
            
            if(count[B[i]-1] ==2) {
                repeatedNumbers.add(B[i]);
                if(repeatedNumbers.size() == 5) {
                    break;
                }
            }
        }
        return repeatedNumbers;
    }
}
