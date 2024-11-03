package com.mycompany.sortedarray;

import java.util.Arrays;

public class SortedArray {
    public static int Search(int[]arr, int key){
    for(int i = 0;i<arr.length;i++){
        if(arr[i]==key){
            return i;
        }
    }
    return -1;
}
    public static int[] Insert(int[] arr, int key){
        int[] newArray= new int[arr.length+1];
        int i=0;
        while (i<arr.length && arr[i] < key){
            newArray[i] = arr[i];
            i++;
        }
        newArray[i] = key;
        while(i<arr.length){
            newArray[i+1] = arr[i];
            i++;
        }
        return newArray;
    }
    public static int[] delete(int[] arr, int key){
        int ind = Search(arr,key);
        if (ind == -1){
            return arr;
        }
        int [] newArray = new int[arr.length-1];
        for (int i=0,j=0;i<arr.length;i++){
            if(i!=ind){
                newArray[j++] = arr[i];
            }
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr ={9,2,3,1,13};
        int searchkey = 5;
        int result = Search(arr,searchkey);
        System.out.println("Element "+searchkey+(result != -1?" found at index "+result:"not found." ));
                                                    //condition ? valueIfTrue : valueIfFalse
        int insertkey = 7;
        arr = Insert(arr, insertkey);
        System.out.println("After inserting "+insertkey+": "+Arrays.toString(arr));
        
        int deletekey = 10;
        arr = delete(arr,deletekey);
        System.out.println("After deleting "+deletekey+": "+Arrays.toString(arr));
    }
}
