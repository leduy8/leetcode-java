package src;

public class lc1732 {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7})); // 1
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2})); // 0
        System.out.println(largestAltitude(new int[]{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81})); // 781
    }

    public static int largestAltitude(int[] gain) {
        int highestLat = 0;
        int current = 0;
        int[] gains = new int[gain.length];

        for (int i = 1; i <= gains.length; i++) {
            current = current + gain[i - 1];
            if (current > highestLat) {
                highestLat = current;
            }
        }

        return highestLat;
    }
}
