package src;

import java.util.Arrays;

public class lc167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9))); // [1,2]
        System.out.println(Arrays.toString(twoSum(new int[] {2,3,4}, 6))); // [1,3]
        System.out.println(Arrays.toString(twoSum(new int[] {-1,0}, -1))); // [1,2]
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[] {};
    }
}