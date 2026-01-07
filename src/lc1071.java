package src;

public class lc1071 {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC")); // ABC
        System.out.println(gcdOfStrings("ABABAB", "ABAB")); // AB
        System.out.println(gcdOfStrings("LEET", "CODE")); // ""
        System.out.println(gcdOfStrings("AAAAAB", "AAA")); // ""
    }

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // Start with the largest possible length str (but shortest of the 2 str) then work downward to 1
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            // The first valid gcd (Greatest Common Divisor). We will return it because it's the longest one
            if (validGcd(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }

        return "";
    }

    public static boolean validGcd(String str1, String str2, int k) {
        int len1 = str1.length();
        int len2 = str2.length();

        // If str1 or str2 cannot divide k -> Then it's not a gcd
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            // If it does, base will be substring from 0 to k
            String base = str1.substring(0, k);
            // We will replace base with "", and if it's a divisor -> it'll replace until empty, same goes both str1 str2
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }
}
