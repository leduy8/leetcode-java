package src.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1614 {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1")); // 3
        System.out.println(maxDepth("(1)+((2))+(((3)))")); // 3
        System.out.println(maxDepth("()(())((()()))")); // 3
    }

    public static int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (isLeftBracket(c)) {
                stack.push(c);
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (isRightBracket(c)) {
                if (stack.size() > 0) {
                    char l = stack.pop();
                    if (isPairBracket(l, c)) {
                        depth--;
                    }
                }
            }
        }

        return maxDepth;
    }
    
    public static boolean isLeftBracket(char c) {
        return c == '(';
    }

    public static boolean isRightBracket(char c) {
        return c == ')';
    }

    public static boolean isPairBracket(char l, char r) {
        return l == '(' && r == ')';
    }

    // Faster and space efficient, but it's not the proper way
    // public int maxDepth(String s) {
    //     int maxDepth = 0;
    //     int depth = 0;

    //     for (char c : s.toCharArray()) {
    //         if (isLeftBracket(c)) {
    //             depth++;
    //             maxDepth = Math.max(maxDepth, depth);
    //         } else if (isRightBracket(c)) {
    //             depth--;
    //         }
    //     }

    //     return maxDepth;
    // }
}
