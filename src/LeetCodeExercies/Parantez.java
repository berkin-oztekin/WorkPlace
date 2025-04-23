package LeetCodeExercies;

import java.util.Stack;

public class Parantez {
    public static void main(String [] args){
    String  s = "{(})";
        System.out.println(isValid(s));

    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;

                char son = stack.pop();
                if ((c == ')' && son != '(') ||
                        (c == '}' && son != '{') ||
                        (c == ']' && son != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // Eğer stack boşsa, tüm parantezler dengelidir
    }
}
