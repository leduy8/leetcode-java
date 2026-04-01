package src;

import java.util.Arrays;

public class lc1657 {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca")); // true
        System.out.println(closeStrings("a", "aa")); // false
        System.out.println(closeStrings("cabbba", "abbccc")); // true
    }

    public static boolean closeStrings(String word1, String word2) {
        // Early exit
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequency of word1
        for (char c: word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        // Count frequency of word2
        for (char c: word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Check if all element in 2 frequencies are the same
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}