package src.school.programmers.co.kr.course30;

import java.util.*;

public class lesson150370 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}))); // [1,3]
        System.out.println(Arrays.toString(solution(
                "2020.01.01",
                new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}))); // [1,4,5]
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int daysToday = toDays(today);

        for (String term : terms) {
            String[] temp = term.split(" ");
            map.putIfAbsent(temp[0], Integer.parseInt(temp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            int expireDays = toDays(temp[0]) + (map.get(temp[1]) * 28) - 1;
            if (expireDays < daysToday) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int toDays(String dateStr) {
        String[] date = dateStr.split("\\.");
        return Integer.parseInt(date[0]) * 12 * 28 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]);
    }
}