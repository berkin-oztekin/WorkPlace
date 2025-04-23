import java.util.HashMap;
import java.util.HashSet;

public class DuplicateStrings {
    public static void main(String [] args){
        String string = "Better Butter";
        String [] array = string.split(string) ;

        HashSet <String> hashSet = new HashSet<String>();

        for(int i = 0 ; i < array[0].length() ; i++){
            hashSet.add(String.valueOf(array[0].charAt(i)));
        }
        System.out.println(hashSet);
    }
}

