package src.easy;

import java.util.HashSet;
import java.util.Set;

public class lc1763 {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay")); // "aAa"
        System.out.println(longestNiceSubstring("Bb")); // "Bb"
        System.out.println(longestNiceSubstring("c")); // ""
    }

    public static String longestNiceSubstring(String s) {
        String ans = recursiveDiviveAndConquer(s);
        return ans;
    }

    public static String recursiveDiviveAndConquer(String s) {
        if (s.length() < 2) {
            return "";
        }

        // Store all chars in string
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // Divine & Conquer
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                // Contains nice character. Noice!
                continue;
            }

            String left = recursiveDiviveAndConquer(s.substring(0, i));
            String right = recursiveDiviveAndConquer(s.substring(i + 1));

            return left.length() >= right.length() ? left : right;
        }

        // Whole string is nice. Noice!
        return s;
    }
}
