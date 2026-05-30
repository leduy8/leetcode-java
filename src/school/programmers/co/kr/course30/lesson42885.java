package src.school.programmers.co.kr.course30;

import java.util.Arrays;

public class lesson42885 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {70, 50, 80, 50}, 100)); // 3
        System.out.println(solution(new int[] {70, 80, 50}, 100)); // 3
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int lifeboats = 0;
        int light = 0;
        int heavy = people.length - 1;

        while (light <= heavy) {
            // Check exists of a pair of people can use same boat
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            lifeboats++;
        }

        return lifeboats;
    }
}
