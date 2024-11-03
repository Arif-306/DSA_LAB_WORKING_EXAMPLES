
package com.mycompany.palindromecheck;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "arif";
        boolean isPalindrome = checkPalindrome(str);
        System.out.println("Is the string a palindrome? " + isPalindrome);
    }
    public static boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start < end) {
            
            if(str.charAt(start) != str.charAt(end)) {
                return true ;
            }
            start++;
            end--;
        }
        return false;
    }
}
