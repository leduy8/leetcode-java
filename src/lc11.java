package src;

public class lc11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[] {1,1})); // 1
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int temp = Math.min(height[l], height[r]) * (r - l);

            if (max < temp) max = temp;
            
            if (height[l] < height[r]) l++;
            else r--;
        }

        return max;
    }
}
