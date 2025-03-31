package src;

import java.util.Stack;

public class lc20 {
    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("[")); // false
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char last = stack.peek();
                if (isPair(last, c)) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }

    public static boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
                (last == '[' && cur == ']') ||
                (last == '{' && cur == '}');
    }
}
