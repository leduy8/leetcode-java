package src.medium;

public class lc1031 {
    public static void main(String[] args) {
        System.out.println(maxSumTwoNoOverlap(new int[] {0,6,5,2,2,5,1,9,4}, 1, 2)); // 20
        System.out.println(maxSumTwoNoOverlap(new int[] {3,8,1,3,2,1,8,9,0}, 3, 2)); // 29
        System.out.println(maxSumTwoNoOverlap(new int[] {2,1,5,6,0,9,5,0,3,8}, 4, 3)); // 31
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
            maxSum(nums, firstLen, secondLen), // firstLen window left, secondLen window right
            maxSum(nums, secondLen, firstLen)  // secondLen window left, firstLen window right
        );
    }

    public static int maxSum(int[] nums, int leftLen, int rightLen) {
        int curSumLeft = 0;
        int curSumRight = 0;
        int curMax = 0;
        int idx = leftLen + rightLen;
        for (int i = 0; i < leftLen; i++) {
            curSumLeft += nums[i];
        }
        for (int i = leftLen; i < leftLen + rightLen; i++) {
            curSumRight += nums[i];
        }

        int maxLeft = curSumLeft;
        while (idx < nums.length) {
            curMax = Math.max(curMax, maxLeft + curSumRight);
            curSumLeft -= nums[idx - leftLen - rightLen];
            curSumLeft += nums[idx - rightLen];
            maxLeft = Math.max(maxLeft, curSumLeft);
            curSumRight -= nums[idx - rightLen];
            curSumRight += nums[idx];
            idx++;
        }

        return Math.max(curMax, maxLeft + curSumRight);
    }
}
