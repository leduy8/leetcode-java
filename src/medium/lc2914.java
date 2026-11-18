package src.medium;

public class lc2914 {
    public static void main(String[] args) {
        System.out.println(minChanges("1001")); // 2
        System.out.println(minChanges("10")); // 1
        System.out.println(minChanges("0000")); // 0
    }

    public static int minChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i+1)) res++;
        }
        return res;
    }
}
