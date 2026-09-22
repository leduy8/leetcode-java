package src.easy;

import java.util.Arrays;

public class lc1652 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt(new int[]{5, 7, 1, 4}, 3))); // [12, 10, 16, 13]
        System.out.println(Arrays.toString(decrypt(new int[]{1, 2, 3, 4}, 0))); // [0, 0, 0, 0]
        System.out.println(Arrays.toString(decrypt(new int[]{2, 4, 9, 3}, -2))); // [12, 5, 6, 13]
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            return result;
        }

        int l = (k > 0) ? 1 : n + k;
        int r = (k > 0) ? k : n - 1;
        int windowSum = 0;

        for (int i = l; i <= r; i++) {
            windowSum += code[i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = windowSum;
            windowSum -= code[l % n];
            l++;
            r++;
            windowSum += code[r % n];
        }

        return result;
    }
}
