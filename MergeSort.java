package com.mycompany.mergesort;

public class MergeSort {
 
    int[] a = {22, 58, 47, 96, 45, 32, 12};
    int[] b = new int[a.length];
    
    void merging(int low, int mid, int high) {
        int left = low;   
        int right = mid + 1;
        int i = low;
        
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                b[i] = a[left];
                left++;
            } else {
                b[i] = a[right];
                right++;
            }
            i++;
        }
        
        while (left <= mid) {
            b[i++] = a[left++];
        }
        
        while (right <= high) {
            b[i++] = a[right++];
        }
        
        for (i = low; i <= high; i++) {
            a[i] = b[i];
        }
    }    
    
    void sort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(low, mid);
            sort(mid + 1, high);
            merging(low, mid, high);
        }
    }
    
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int max = obj.a.length;
        
        System.out.println("Array Before Sorting:");
        for (int i = 0; i < max; i++) {
            System.out.print(obj.a[i] + " ");
        }
        System.out.println();
        
        obj.sort(0, max - 1);
        
        System.out.println("\nArray After Sorting:");
        for (int i = 0; i < max; i++) {
            System.out.print(obj.a[i] + " ");
        }
        System.out.println();
    }
}
