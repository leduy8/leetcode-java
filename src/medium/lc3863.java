package src.medium;

public class lc3863 {
    public static void main(String[] args) {
        System.out.println(minOperations("dog")); // 1
        System.out.println(minOperations("card")); // 2
        System.out.println(minOperations("gf")); // -1
        System.out.println(minOperations("cab")); // 2
        System.out.println(minOperations("klo")); // 0
        System.out.println(minOperations("lx")); // 0
        System.out.println(minOperations("p")); // 0
    }

    public static int minOperations(String s) {
        int n = s.length();

        boolean isSorted = true;
        char mn = s.charAt(0);
        char mx = s.charAt(0);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
            }
            mn = (char) Math.min(mn, c);
            mx = (char) Math.max(mx, c);
        }
        
        // Case 0: Sorted array
        if (isSorted) {
            return 0;
        }
        
        if (n == 2) {
            return -1;
        }

        // Case 1: Min char or max char is at the edge
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }

        // Case 2: Min char or max char at the proper prefix or suffix
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }

        // Case 3: Others
        return 3;
    }
}