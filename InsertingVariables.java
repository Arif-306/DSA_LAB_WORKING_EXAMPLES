

package com.mycompany.insertingvariables;

import java.util.Arrays;
import java.util.Scanner;

public class InsertingVariables {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
      
        int[] LA = {10, 20, 30, 40, 50}; 
        
        System.out.println("Initial Array: " + Arrays.toString(LA));
        
        // input lena ha user se
        System.out.print("Enter index K where you want to insert: ");
        int K = scanner.nextInt();
        
        System.out.print("Enter a positive integer ITEM to insert: ");
        int ITEM = scanner.nextInt();
        
        // insert method ko call krna ha 
        LA = insert(LA, K, ITEM);
        
        System.out.println("Final Array: " + Arrays.toString(LA));
        
        scanner.close();
    }
    
    // methods ki helps se Method  ko handle krna ha insertions ki conditions ke sath 
    public static int[] insert(int[] LA, int K, int ITEM) {
        // Check that K is within range
        if (K < 0 || K >= LA.length) {
            System.out.println("Error: Index K is out of range.");
            return LA;
        }

        // check kare ITEM ki value positive ha ?
        if (ITEM <= 0) {
            System.out.println("Error: ITEM must be a positive integer.");
            return LA;
        }

        // compare krna ha ITEM ke elements ko K se
        if (ITEM < LA[K]) {
            // ek new array banayege extra space ke sath for new ITEM ke liye
            int[] newArray = new int[LA.length + 1];
            
            //jb tk K nhi aata elements ko copy krte rahe 
            for (int i = 0; i < K; i++) {
                newArray[i] = LA[i];
            }
            
            // Insert ITEM index K ki jagah pr 
            newArray[K] = ITEM;
            
            // index k ke bd saare bache hue elements ko copy krna ha 
            for (int i = K ; i < LA.length; i++) {
                newArray[i + 1] = LA[i];
            }
            
            System.out.println("Inserted " + ITEM + " at index " + K);
            return newArray;
        } else {
            System.out.println(LA[K] + " at index " + K + " is greater than user's entered " + ITEM);
            return LA; // original array ko return karenge 0 insertion ke sath 
        }
    }
}


