package LeetCodeExercies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Rome {
    public static  void main (String [] args){
        System.out.println(romanToInt("IXV"));

    }

    public static int romanToInt(String s) {
        HashMap<Character , Integer> romanMap = new HashMap<Character , Integer>();
        romanMap.put('I' , 1);
        romanMap.put('V' ,5);
        romanMap.put('X' ,10);
        romanMap.put('L' ,50);
        romanMap.put('C', 100);
        romanMap.put('D' ,500);
        romanMap.put('M'  ,1000);

        ArrayList<Character> charList = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            charList.add(ch);
        }

        int sum = 0 ;


            for(int i = 0 ; i < charList.size() - 1;){
                char x = charList.get(0);
                char y = charList.get(1);

                if(x == y) {
                    sum = sum + romanMap.get(x);
                    charList.remove(i);
                }

                if(romanMap.get(x)< romanMap.get(y)) {
                    sum = sum - romanMap.get(x) ;
                    charList.remove(i);
                }

                if(romanMap.get(x) > romanMap.get(y)) {
                    sum = romanMap.get(x) + sum;
                    charList.remove(i);
                }
            }

        return sum + romanMap.get(charList.get(charList.size() - 1)) ;
    }
}
