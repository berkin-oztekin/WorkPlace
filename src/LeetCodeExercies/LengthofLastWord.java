package LeetCodeExercies;

import java.util.Arrays;

public class LengthofLastWord {
    public static void main(String [] args){
        String s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        /*System.out.println(s.length());
        String[] array  = s.split(" ");
        String LastWord = array[array.length-1];
        return LastWord.length() ;,

         */
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            --j;
        }
        return i - j;
    }
}
