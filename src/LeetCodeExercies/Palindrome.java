package LeetCodeExercies;

import java.util.*;

public class Palindrome {
    public static void main (String [] args){
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int n = x % 10;
            reversed = reversed * 10 + n;
            x = x / 10;
        }

        return original == reversed;
    }

        /*  String temp = Integer.toString(x);
         char [] array = temp.toCharArray();
         int mid = array.length / 2;

        char[] firstHalf = Arrays.copyOfRange(array, 0, mid);
        char[] secondHalf = Arrays.copyOfRange(array, mid, array.length);
        String reversed = new StringBuilder(new String(secondHalf)).reverse().toString();

        if(Arrays.toString(firstHalf).equals(Arrays.toString(reversed.toCharArray()))){
            return true;
        }else{
            char[] firstHalf1 = Arrays.copyOfRange(array, 0, mid);
            char[] secondHalf1 = Arrays.copyOfRange(array, ++mid, array.length);
            String reversed1 = new StringBuilder(new String(secondHalf1)).reverse().toString();

            return Arrays.toString(firstHalf1).equals(Arrays.toString(reversed1.toCharArray()));
        }

        */
}

