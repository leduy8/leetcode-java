package src.easy;

public class lc2269 {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2)); // 2
        System.out.println(divisorSubstrings(430043, 2)); // 2
    }

    public static int divisorSubstrings(int num, int k) {
        int res = 0;
        int tmp = num;
        int divisor = (int) Math.pow(10, k);

        while (tmp >= divisor / 10) {
            int cur = tmp % divisor;
            if (cur > 0 && num % cur == 0) res++;
            tmp /= 10;
        }

        return res;
    }

    // Less efficient, easier to implement.
    // Using Sliding Window approach
    
    // public static int divisorSubstrings(int num, int k) {
    //     int res = 0;
    //     int l = 0;
    //     char[] numCharArr = Integer.toString(num).toCharArray();

    //     for (int r = k - 1; r < numCharArr.length; r++) {
    //         int n = convertToNum(numCharArr, l++, r);
    //         if (n == 0) continue;
    //         if (num % n == 0) res++;
    //     }

    //     return res;
    // }

    // public static int convertToNum(char[] arr, int l, int r) {
    //     int tmp = 1;
    //     int n = 0;
    //     while (l <= r) {
    //         n += (arr[r--] - '0') * tmp;
    //         tmp *= 10;
    //     }
    //     return n;
    // }
}
