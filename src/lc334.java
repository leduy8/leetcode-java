package src;

public class lc334 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] {1,2,3,4,5})); // true
        System.out.println(increasingTriplet(new int[] {5,4,3,2,1})); // false
        System.out.println(increasingTriplet(new int[] {2,1,5,0,4,6})); // true
        System.out.println(increasingTriplet(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1})); // true
    }

    public static boolean increasingTriplet(int[] nums) {
        // First boundary
        int first = Integer.MAX_VALUE;
        // Second boundary
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else {
                if (num <= second) {
                    second = num;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
