package src.school.programmers.co.kr.course30;

import java.util.*;

public class lesson176962 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}))); // ["korean", "english", "math"]
        System.out.println(Arrays.toString(solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}))); // ["science", "history", "computer", "music"]
        System.out.println(Arrays.toString(solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}))); // ["bbb", "ccc", "aaa"]
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<String[]> stack = new ArrayDeque();
        String curPlan = null;
        String curTime = null;
        String curRemainingTime = null;

        for (String[] plan: plans) {
            // First iteration
            if (curPlan == null) {
                curPlan = plan[0];
                curTime = plan[1];
                curRemainingTime = plan[2];
            }
            // TODO
        }

        // Resolve remaining plans
        while(stack.size() > 0) {
            String[] temp = stack.pop();
            answer.add(temp[0]);
        }

        return answer.toArray(String[]::new);
    }

    public static int toMinutes(String timeStr) {
        String[] temp = timeStr.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}