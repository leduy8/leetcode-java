package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc2390 {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e")); // lecoe
        System.out.println(removeStars("erase*****")); // ""
    }

    public static String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        return res.reverse().toString();
    }
}