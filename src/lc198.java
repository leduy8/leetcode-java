package src;

public class lc198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1})); // 4
        System.out.println(rob(new int[] {2,7,9,3,1})); // 12
    }

    public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        
        // [rob1, rob2, n, n+1, ...]
        for (int n: nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}
