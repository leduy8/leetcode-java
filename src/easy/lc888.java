package src.easy;

// import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class lc888 {
    public static void main(String[] args) {
        System.out.println(fairCandySwap(new int[] {1,1}, new int[] {2,2})); // [1,2]
        System.out.println(fairCandySwap(new int[] {1,2}, new int[] {2,3})); // [1,2]
        System.out.println(fairCandySwap(new int[] {2}, new int[] {1,3})); // [2,3]
    }

    // No Binary Search
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = sum(aliceSizes);
        int bobSum = sum(bobSizes);
        int target = (aliceSum + bobSum) / 2;
        Set<Integer> bobSet = new HashSet<>();

        for (int v : bobSizes) {
            bobSet.add(v);
        }

        for (int i = 0; i < aliceSizes.length; i++) {
            int x = aliceSizes[i];
            // Formula: 
            //    aliceSum - x + y = target 
            // => y = target - aliceSum + x
            int y = target - aliceSum + x;
            boolean found = bobSet.contains(y);
            if (found) {
                return new int[] {x, y};
            }
        }

        return new int[] {};
    }

    // Binary Search
    // public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    //     Arrays.sort(bobSizes);
    //     int aliceSum = sum(aliceSizes);
    //     int bobSum = sum(bobSizes);
    //     int target = (aliceSum + bobSum) / 2;

    //     for (int i = 0; i < aliceSizes.length; i++) {
    //         int x = aliceSizes[i];
    //         // Formula: 
    //         //    aliceSum - x + y = target 
    //         // => y = target - aliceSum + x
    //         int y = target - aliceSum + x;
    //         int found = binarySearch(bobSizes, y);
    //         if (found != -1) {
    //             return new int[] {x, bobSizes[found]};
    //         }
    //     }

    //     return new int[] {};
    // }

    public static int binarySearch(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == num) return m;
            else if (arr[m] > num) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int v : arr) {
            sum += v;
        }
        return sum;
    }
}
