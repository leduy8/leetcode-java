package src.easy;

import java.util.Arrays;

public class lc338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2))); // [0, 1, 1]
        System.out.println(Arrays.toString(countBits(5))); // [0, 1, 1, 2, 1, 2]
    }
    
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int ones = 0;
            int tmp = i;
            while (tmp > 0) {
                int bit = tmp & 1; // Extract the rightmost bit
                if (bit == 1) ones++;
                tmp >>= 1;
            }
            res[i] = ones;
        }
        
        return res;
    }
}
