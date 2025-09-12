package src;

import java.util.*;

public class lc3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }

    public static int lengthOfLongestSubstring(String s) {
        // Create a hashset to store unique chars
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // Expandable sliding window
        for (int right = 0; right < s.length(); right++) {
            // Remove duplicates in set
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            // Add current to set
            seen.add(s.charAt(right));
            // Check max length again
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}