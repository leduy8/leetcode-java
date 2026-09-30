package src.medium;

public class lc1016 {
    public static void main(String[] args) {
        System.out.println(queryString("0110", 3)); // true
        System.out.println(queryString("0110", 4)); // false
    }

    // String
    public static boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = s.indexOf(Integer.toBinaryString(i)) != -1;
            if (!found) return false;
        }
        return true;
    }

    // Sliding window
    // public static boolean queryString(String s, int n) {
    //     for (int i = 1; i <= n; i++) {
    //         boolean found = isSubstr(s, convertToBinary(i));
    //         if (!found) return false;
    //     }
    //     return true;
    // }

    // public static boolean isSubstr(String s, String bin) {
    //     int l = 0;
    //     for (int r = bin.length(); r <= s.length(); r++) {
    //         if (s.substring(l, r).equals(bin)) return true;
    //         l++;
    //     }
    //     return false;
    // }

    // public static String convertToBinary(int number) {
    //     StringBuilder binary = new StringBuilder();
    //     while (number > 0) {
    //         binary.append(number % 2);
    //         number /= 2;
    //     }
    //     return binary.reverse().toString();
    // }
}
