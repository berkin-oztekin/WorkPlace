import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String LetterCount(String str) {
        int count = 1;
        String result = "";
        String[] stringArray = str.split(" ");

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = i + 1 ; j < stringArray[i].length(); j++) {
                if (stringArray[i].charAt(i) == stringArray[i].charAt(j)) {
                    count++;
                }
            }
            if (count > 1) {
                result = stringArray[i];
                break; // Stop searching once a word with repeated letters is found
            } else {
                result = "-1";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Keep this function call here
        System.out.println(LetterCount("Hello apple pie "));
    }
}

