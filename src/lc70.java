package src;

public class lc70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(4)); // 5
        System.out.println(climbStairs(5)); // 8
        System.out.println(climbStairs(6)); // 13
    }

    public static int climbStairs(int n) {
        // First 3 stairs, always steps = stairs
        if (n <= 3) return n;

        // In other case, we will base on this formula
        //        Step Index	prev2	prev1	cur
        //        3	            2	    3	    5
        //        4	            3	    5	    8
        //        5	            5	    8	    13
        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }
}
