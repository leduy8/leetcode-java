package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(decodeString("3[a2[c]]")); // "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")); // "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
    }

    public static String decodeString(String s) {
        // Stack is needed for nested case
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int repeatCount = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build repeat count
                repeatCount = repeatCount * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push to stack then reset repeat count and cur
                countStack.push(repeatCount);
                stringStack.push(cur);
                cur = new StringBuilder();
                repeatCount = 0;
            } else if (ch == ']') {
                // Append cur with repeat to existing string (prev)
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                prev.append(String.valueOf(cur).repeat(Math.max(0, repeat)));
                // Set cur to existing string (prev)
                cur = prev;
            } else {
                cur.append(ch);
            }
        }

        return cur.toString();
    }
}
