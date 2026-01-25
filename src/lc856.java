package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc856 {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()")); // 1
        System.out.println(scoreOfParentheses("(())")); // 2
        System.out.println(scoreOfParentheses("()()")); // 2
    }

    public static int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int score = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}
