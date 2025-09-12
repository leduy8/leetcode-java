package src;

import java.util.*;

public class lc2300 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7))); // [4,0,3]
        System.out.println(Arrays.toString(successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16))); // [2,0,2]
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        
        for (int i = 0; i < spells.length; i++) {
            int index = findMiddleIndexBinarySearch(potions, spells[i], success);
            res[i] = potions.length - index;
        }

        return res;
    }
    
    public static int findMiddleIndexBinarySearch(int[] arr, int pivot, long success) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) arr[mid] * pivot < success) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}