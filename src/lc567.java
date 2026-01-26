package src;

import java.util.Arrays;

public class lc567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
    }

    public static boolean checkInclusion(String s1, String s2) {
        // False when s1 len > s2 len
        if (s1.length() > s2.length()) return false;

        // 2 alphabetical array
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        // Fill s1 array
        for (char c: s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        // Create window, fill s2 array
        for (int i = 0; i < s1.length(); i++) {
            s2Arr[s2.charAt(i) - 'a']++;
        }

        // Early exit if found inclusion
        if (Arrays.equals(s1Arr, s2Arr)) {
            return true;
        }

        // Slide window, check for inclusion
        for (int i = s1.length(); i < s2.length(); i++) {
            s2Arr[s2.charAt(i - s1.length()) - 'a']--;
            s2Arr[s2.charAt(i) - 'a']++;

            if (Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }
        }

        return false;
    }
}
