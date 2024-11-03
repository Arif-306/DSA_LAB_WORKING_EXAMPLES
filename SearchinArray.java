

package com.mycompany.searchinarray;
import java.util.Scanner;

public class SearchinArray{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // array ki example
        int[] LA = {10, 20, 30, 40, 50, 60};
        
        //item ki value leni ha user se 
        System.out.print("Enter the item to search: ");
        int ITEM = scanner.nextInt();
        
        // Search krna ha ITEM se array main or uska index lena ha 
        int index = search(LA, ITEM);
        
        if (index == -1) {
            System.out.println("Item not found in the array.");
        } else {
            //  right neighbors print krna ha 
            System.out.println("Right neighbors:");
            printRightNeighbors(LA, index);
            
            //  left neighbors print karna ha 
            System.out.println("Left neighbors:");
            printLeftNeighbors(LA, index);
        }
        
        scanner.close();
    }
    
    // ek method ha jo search karenge ITEM ke liye array or return karwana ha uske index se 
    public static int search(int[] LA, int ITEM) {
        for (int i = 0; i < LA.length; i++) {
            if (LA[i] == ITEM) {
                return i; 
            }
        }
        return -1; 
    }
    
    //method ha right neighbors ko print karwane ka liye
    public static void printRightNeighbors(int[] LA, int index) {
        if (index + 1 < LA.length) {
            System.out.print(LA[index + 1] + " ");
            if (index + 2 < LA.length) {
                System.out.print(LA[index + 2]);
            } else {
                System.out.print("no right neighbor");
            }
        } else {
            System.out.println("no right neighbor");
        }
        System.out.println(); // Line break
    }
    
    //method ha left neighbors ko print karwane ke liye 
    public static void printLeftNeighbors(int[] LA, int index) {
        if (index - 1 >= 0) {
            System.out.print(LA[index - 1] + " ");
            if (index - 2 >= 0) {
                System.out.print(LA[index - 2]);
            } else {
                System.out.print("no left neighbor");
            }
        } else {
            System.out.println("no left neighbor");
        }
        System.out.println(); 
    }
}
