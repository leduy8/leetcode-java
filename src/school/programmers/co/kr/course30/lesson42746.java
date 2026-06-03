package src.school.programmers.co.kr.course30;

import java.util.Arrays;

public class lesson42746 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2})); // "6210"
        System.out.println(solution(new int[] {3, 30, 34, 5, 9})); // "9534330"
    }

    public static String solution(int[] numbers) {
        String[] numsAsStr = prepareData(numbers);
        Arrays.sort(numsAsStr, (a, b) -> (b + a).compareTo(a + b));
        String ans = String.join("", numsAsStr);
        return ans.charAt(0) != '0' ? ans : "0";
    }

    public static String[] prepareData(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        return s;
    }
}
