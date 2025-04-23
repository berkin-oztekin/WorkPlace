package LeetCodeExercies;

import java.util.ArrayList;
import java.util.List;

public class FindingOccurance {
    public static void main(String[] args){
        String haystack = "leetcode", needle = "leeto" ;
        System.out.println(strStr(haystack, needle));
    }


    public static int strStr(String haystack, String needle) {
    /*    int index = haystack.indexOf(needle);

        if (index != -1)
            return index;

        return -1 ;

     */
        if(needle == null || needle.isEmpty()) return 0;

        int n = needle.length();
        int hLen = haystack.length();

        if(n > hLen) return - 1;
        char first = needle.charAt(0);

        for(int i = 0; i + n <= hLen; i++) {
            if(haystack.charAt(i) == first && needle.equals(haystack.substring(i, i + n))) return i;
        }
        return - 1;
    }
}
