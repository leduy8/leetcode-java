package src.school.programmers.co.kr.course30;

import java.util.*;

public class lesson176962 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{
                {"korean", "11:40", "30"}, 
                {"english", "12:10", "20"}, 
                {"math", "12:30", "40"}}))); // ["korean", "english", "math"]
        System.out.println(Arrays.toString(solution(new String[][]{
                {"science", "12:40", "50"}, 
                {"music", "12:20", "40"}, 
                {"history", "14:00", "30"}, 
                {"computer", "12:30", "100"}}))); // ["science", "history", "computer", "music"]
        System.out.println(Arrays.toString(solution(new String[][]{
                {"aaa", "12:00", "20"}, 
                {"bbb", "12:10", "30"}, 
                {"ccc", "12:40", "10"}}))); // ["bbb", "ccc", "aaa"]
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Deque<String[]> stack = new ArrayDeque<>();

        // Sort by start time
        Arrays.sort(plans, Comparator.comparing(p -> toMinutes(p[1])));

        String curName = plans[0][0];
        int curTime = toMinutes(plans[0][1]);
        int curRemain = Integer.parseInt(plans[0][2]);

        for (int i = 1; i < plans.length; i++) {
            int nextStart = toMinutes(plans[i][1]);
            int availableTime = nextStart - curTime;
            
            // Try to finish current plan + stack plans
            while (true) {
                if (curRemain <= availableTime) {
                    // Finish current plan
                    availableTime -= curRemain;
                    answer.add(curName);
                    
                    if (stack.isEmpty()) {
                        break;
                    }
                    
                    // Resume paused plan
                    String[] prev = stack.pop();
                    curName = prev[0];
                    curRemain = Integer.parseInt(prev[1]);
                } else {
                    // Can't finish -> pause current
                    curRemain -= availableTime;
                    stack.push(new String[] {curName, String.valueOf(curRemain)});
                    break;
                }
            }
            
            // Start new plan
            curName = plans[i][0];
            curTime = nextStart;
            curRemain = Integer.parseInt(plans[i][2]);
        }
        
        // Finish last running plan
        answer.add(curName);

        // Resolve remaining plans
        while(!stack.isEmpty()) {
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