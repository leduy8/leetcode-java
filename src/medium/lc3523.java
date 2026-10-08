package src.medium;

// import java.util.ArrayDeque;
// import java.util.Deque;

public class lc3523 {
    public static void main(String[] args) {
        System.out.println(maximumPossibleSize(new int[] {4,2,5,3,5})); // 3
        System.out.println(maximumPossibleSize(new int[] {1,2,3})); // 3
    }

    public static int maximumPossibleSize(int[] nums) {
        int cnt = 0;
        int maxSeen = 0;

        for (int n : nums) {
            if (n >= maxSeen) {
                cnt++;
                maxSeen = n;
            }
        }

        return cnt;
    }

    // Stack
    // public static int maximumPossibleSize(int[] nums) {
    //     Deque<Integer> stack = new ArrayDeque<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         if (stack.isEmpty() || stack.peek() <= nums[i]) {
    //             stack.push(nums[i]);
    //         }
    //     }

    //     return stack.size();
    // }
}
