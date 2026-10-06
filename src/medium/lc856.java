package src.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc856 {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()")); // 1
        System.out.println(scoreOfParentheses("(())")); // 2
        System.out.println(scoreOfParentheses("()()")); // 2
    }

    // Stack
    public static int scoreOfParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.poll();
                if (s.charAt(i - 1) != ')') {
                    score += Math.pow(2, stack.size());
                }
            }
        }

        return score;
    }

    // No Stack
    // public static int scoreOfParentheses(String s) {
    //     int score = 0;
    //     int depth = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == '(') {
    //             depth++;
    //         } else if (c == ')') {
    //             depth--;
    //             if (s.charAt(i - 1) != ')') {
    //                 score += Math.pow(2, depth);
    //             }
    //         }
    //     }

    //     return score;
    // }
}
