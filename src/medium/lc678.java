package src.medium;

import java.util.Deque;
import java.util.ArrayDeque;

public class lc678 {
    public static void main(String[] args) {
        System.out.println(checkValidString("()")); // true
        System.out.println(checkValidString("(*)")); // true
        System.out.println(checkValidString("(*))")); // true
        System.out.println(checkValidString("(")); // false

    }

    public static boolean checkValidString(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                starStack.push(i);
            }
            else if (c == '(') {
                stack.push(i);
            }
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.poll();
                }
                else if (!starStack.isEmpty()) {
                    starStack.poll();
                }
                else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty() && !starStack.isEmpty()) {
            if (stack.poll() > starStack.poll()) {
                return false; // '(' after '*' by index
            }
        }

        return stack.isEmpty();
    }
}