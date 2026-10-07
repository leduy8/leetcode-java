package src.medium;

public class lc875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8)); // 4
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 5)); // 30
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 6)); // 23
        System.out.println(minEatingSpeed(new int[] {805306368,805306368,805306368}, 1000000000)); // 3
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int minK = Integer.MAX_VALUE;
        int max = findMax(piles);
        int l = 1;
        int r = max;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long eatTime = hoursToEat(piles, m);
            if (eatTime > h) {
                l = m + 1;
            } else {
                minK = Math.min(minK, m);
                r = m - 1;
            }
        }

        return minK;
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (max < i) max = i;
        }
        return max;
    }

    public static long hoursToEat(int[] piles, int curK) {
        long res = 0;
        for (int p : piles) {
            res += (p + curK - 1) / curK;
        }
        return res;
    }
}
