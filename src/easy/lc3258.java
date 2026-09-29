package src.easy;

public class lc3258 {
    public static void main(String[] args) {
        System.out.println(countKConstraintSubstrings("10101", 1)); // 12
        System.out.println(countKConstraintSubstrings("1010101", 2)); // 25
        System.out.println(countKConstraintSubstrings("11111", 1)); // 15
    }

    public static int countKConstraintSubstrings(String s, int k) {
        int res = 0;
        int l = 0;
        int oneCnt = 0;
        int zeroCnt = 0;

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '1') {
                oneCnt++;
            } else if (s.charAt(r) == '0') {
                zeroCnt++;
            }

            while (zeroCnt > k && oneCnt > k) {
                if (s.charAt(l) == '1') {
                    oneCnt--;
                } else if (s.charAt(l) == '0') {
                    zeroCnt--;
                }
                l++;
            }

            res += r - l + 1;
        }

        return res;
    }
}
