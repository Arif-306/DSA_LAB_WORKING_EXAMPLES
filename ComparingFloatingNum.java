

package com.mycompany.comparingfloatingnum;
import java.util.Scanner;


public class ComparingFloatingNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter First Floating-point numbers: ");
        double num1 = scanner.nextDouble();
        
        System.out.println("Enter second floating-point number: ");
        double num2 = scanner.nextDouble();
        
        
        if(areEquaUptoThreeDecimalPlaces(num1 , num2)) {
            System.out.println("The number are same upto three decimal places.");
        }
        else {
            System.out.println("The numbers are different.");
        }
        scanner.close();
    }
    public static boolean areEquaUptoThreeDecimalPlaces(double num1, double num2 ) {
      num1 = Math.round(num1 * 1000);   
      num2 = Math.round(num2 * 1000);   
      
      return num1 == num2;
    }
    
}
