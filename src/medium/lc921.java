package src.medium;

import java.util.*;

public class lc921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())")); // 1
        System.out.println(minAddToMakeValid("(((")); // 3
        System.out.println(minAddToMakeValid("()()")); // 0
        System.out.println(minAddToMakeValid("()))((")); // 4
    }

    // Stack
    public static int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                Character tmp = stack.poll();
                if (tmp == null) res++;
            }
        }

        return res + stack.size();
    }

    // No Stack
    // public static int minAddToMakeValid(String s) {
    //     int res = 0;
    //     int depth = 0;

    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             depth++;
    //         } else if (depth == 0) {
    //             res++;
    //         } else {
    //             depth--;
    //         }
    //     }

    //     return res + depth;
    // }
}
