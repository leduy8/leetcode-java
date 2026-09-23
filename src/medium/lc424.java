package src.medium;

public class lc424 {
    public static void main(String[] args) {
        characterReplacement("ABAB", 2); // 4
        characterReplacement("AABABBA", 1); // 4
    }

    public static int characterReplacement(String s, int k) {
        int res = 0;

        // Sliding window 26 times, each time for a character in alphabet
        for (char c = 'A'; c <= 'Z'; c++) {
            int nonTargetChar = 0;
            int l = 0;

            for (int r = 0; r < s.length(); r++) {
                // Try to flip whenever chance we get
                if (s.charAt(r) != c) {
                    nonTargetChar++;
                }

                // If exceed k, revert back by shrinking window
                while (nonTargetChar > k) {
                    if (s.charAt(l++) != c) nonTargetChar--;
                }

                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }
}
