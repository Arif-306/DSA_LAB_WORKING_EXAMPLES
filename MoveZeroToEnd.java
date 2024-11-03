
package com.mycompany.movezerotoend;


public class MoveZeroToEnd {

    public static void main(String[] args) {
        int[] x = {0,2,0,9,0,6,7};
        moveZero(x);
        System.out.println("Array after moving zero to the end :");
        printArray(x);
    }
public static void moveZero(int[] x) {
    int index = 0;
    
    for(int i = 0; i < x.length; i++) {
        if (x[i] != 0) {
            x[index] = x[i];
            index++;
        }
    }
    while (index < x.length) {
        x[index] = 0;
        index++;
    }
}
public static void printArray(int[] x) {
    for (int i = 0; i< x.length; i++) {
        System.out.println(x[i] + " ");
    }
    System.out.println();
}

}

