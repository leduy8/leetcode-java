package src.easy;

import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;

public class lc20 {
    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("[")); // false
    }

    static Map<Character, Character> BRACKETS_MAP = Map.of(
        '(', ')',
        '{', '}',
        '[', ']'
    );

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (BRACKETS_MAP.containsKey(c)) {
                stack.push(c);
            } else {
                Character top = stack.poll(); // pop item or null
                if (top == null || BRACKETS_MAP.get(top) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
