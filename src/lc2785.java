package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc2785 {
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde")); // lEOtcede
        System.out.println(sortVowels("lYmpH")); // lYmpH
    }

    public static String sortVowels(String s) {
        if (s == null || s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>();

        // Get all vowels in the string
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Sort vowels
        Collections.sort(vowels);

        int j = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(vowels.get(j++));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static Boolean isVowel(char c) {
        return c == 'u' || c == 'i' || c == 'a' || c == 'e' || c == 'o' || c == 'U' || c == 'I' || c == 'A' || c == 'E' || c == 'O';
    }
}
