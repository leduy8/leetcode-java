package src;

public class lc5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab
        System.out.println(longestPalindrome("cbbd")); // bb
    }

    private static int[] expand(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }

        return new int[]{left + 1, right - 1};
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) return "";

        char[] arr = s.toCharArray();
        int start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
            // odd length
            int[] odd = expand(arr, i, i);
            // even length
            int[] even = expand(arr, i, i + 1);

            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }
            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }

        return s.substring(start, end + 1);
    }
}
