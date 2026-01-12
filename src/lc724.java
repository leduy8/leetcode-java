package src;

public class lc724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6})); // 3
        System.out.println(pivotIndex(new int[]{1,2,3})); // -1
        System.out.println(pivotIndex(new int[]{2,1,-1})); // 0
    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }


//    My stupid way
//    public static int pivotIndex(int[] nums) {
//        int[] myPrefixSum = prefixSum(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0) {
//                if (0 == (myPrefixSum[nums.length - 1] - myPrefixSum[i])) {
//                    return i;
//                }
//            } else if (i == nums.length - 1) {
//                if (myPrefixSum[i - 1] == 0) {
//                    return i;
//                }
//            } else {
//                if (myPrefixSum[i - 1] == (myPrefixSum[nums.length - 1] - myPrefixSum[i])) {
//                    return i;
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    public static int[] prefixSum(int[] nums) {
//        int len = nums.length;
//        int[] prefixSum = new int[len];
//        prefixSum[0] = nums[0];
//
//        for (int i = 1; i < len; i++) {
//            prefixSum[i] = prefixSum[i - 1] + nums[i];
//        }
//
//        return prefixSum;
//    }
}
