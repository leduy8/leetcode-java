package src;

public class lc875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8)); // 4
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 5)); // 30
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 6)); // 23
        System.out.println(minEatingSpeed(new int[] {805306368,805306368,805306368}, 1000000000)); // 3
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n: piles) {
            if (n > max) max = n;
        }

        int l = 1;
        int r = max;
        // Initial min is eating speed to finish the biggest pile
        int min = r;

        while (l <= r) {
            int k = l + (r - l) / 2;
            // For large dataset
            long hours = 0;

            // Get eating speed to finish all piles
            for (int p: piles) {
                // Same as: hours += (int) Math.ceil((double) p / k);
                hours += (p + k - 1L) / k;
            }

            // If finish eating before guard back, check if that speed is min.
            // r = k - 1 -> Find out if we can finish eating with slower speed
            // Else can't finish food on time -> Eat faster
            if (hours <= h) {
                min = Math.min(min, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return min;
    }
}
