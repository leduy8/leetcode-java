package src.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1541 {
    public static void main(String[] args) {
        System.out.println(minInsertions("(()))")); // 1
        System.out.println(minInsertions("())")); // 0
        System.out.println(minInsertions("))())(")); // 3

    }

    public static int minInsertions(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int res = 0;
        int consecutive = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (consecutive == 1) {
                    res++;
                    consecutive = 0;
                    if (!stack.isEmpty()) stack.pop();
                    else res++;
                }
                stack.push(c);
            } else if (c == ')') {
                consecutive++;
                if (consecutive == 2) {
                    if (!stack.isEmpty()) stack.pop();
                    else res++;
                    consecutive = 0;
                }
            }
        }

        if (consecutive == 1) {
            res++;
            consecutive = 0;
            if (!stack.isEmpty()) stack.pop();
            else res++;
        }

        if (!stack.isEmpty()) {
            res += 2 * stack.size();
        }

        return res;
    }
}