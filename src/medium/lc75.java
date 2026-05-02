package src.medium;

public class lc75 {
    public static void main(String[] args) {
        sortColors(new int[] {2,0,2,1,1,0}); // [0,0,1,1,2,2]
        System.out.println("======================");
        sortColors(new int[] {2,0,1}); // 0,1,2
    }

    public static void sortColors(int[] nums) {
        System.out.println("Before");
        printArray(nums);

        int low = 0; // For 0
        int mid = 0; // For 1
        int high = nums.length - 1; // For 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap mid and low, move both forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Move mid forward
                mid++;
            } else { // nums[mid] == 2
                // Swap mid and high, move high backward
                swap(nums, mid, high);
                // Only decrement high because we need to evaluate the swapped value either
                high--;
            }
        }

        System.out.println("After");
        printArray(nums);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
}
