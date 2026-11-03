package src.medium;

import java.util.Arrays;

public class lc1930 {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca")); // 3
        System.out.println(countPalindromicSubsequence("adc")); // 0
        System.out.println(countPalindromicSubsequence("bbcbaba")); // 4
    }

    public static int countPalindromicSubsequence(String s) {
        int res = 0;
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        Arrays.fill(firstOcc, -1);
        Arrays.fill(lastOcc, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // For first occ case
            if (firstOcc[c - 'a'] == -1) {
                firstOcc[c - 'a'] = i;
            }
            lastOcc[c - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (firstOcc[i] == -1 || lastOcc[i] - firstOcc[i] < 2) continue;

            int start = firstOcc[i];
            int end = lastOcc[i];
            boolean[] seen = new boolean[26];
            int unique = 0;

            for (int j = start + 1; j < end; j++) {
                char c = s.charAt(j);
                if (!seen[c - 'a']) {
                    seen[c - 'a'] = true;
                    unique++;
                }
            }

            res += unique;
        }

        return res;
    }
}