
package com.mycompany.increasingdecreasing;

import java.util.Scanner;

public class IncreasingDecreasing {
    
    public static String checkOrder(int num1, int num2, int num3 ) {
        if(num1 < num2 && num2 < num3) {
            return "increasing";
        } else if (num1 > num2 && num2 > num3) {
        return "decreasing";
    } else 
        {
            return "Neither increasing nor decreasing order";
            }
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
        System.out.println("Enter first number");
        int num1 = scanner.nextInt();
        
        System.out.println("Enter second number");
        int num2 = scanner.nextInt();
        
        System.out.println("Enter third number");
        int num3 = scanner.nextInt();
        
        String result = checkOrder(num1, num2, num3);
        System.out.println(result);
        
        scanner.close();
    }
}
