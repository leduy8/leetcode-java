package src.easy;

public class lc268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 3, 0, 1 })); // 2
        System.out.println(missingNumber(new int[] { 0, 1 })); // 2
        System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 })); // 8
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        int sumNums = 0;
        
        for (int i = 0; i < nums.length + 1; i++) {
            if (i != nums.length) {
                sumNums += nums[i];
            }
            sum += i;
        }

        return sum - sumNums;
    }
}
