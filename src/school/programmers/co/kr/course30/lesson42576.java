package src.school.programmers.co.kr.course30;

import java.util.HashMap;
import java.util.Map;

public class lesson42576 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"})); // leo
        System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinco", "filip"}, new String[] {"josipa", "filip", "marina", "nikola"})); // vinco
        System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"})); // mislav
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // Count participant
        for (String p: participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // Subtract completion
        for (String c: completion) {
            int count = map.get(c); 
            if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, count - 1);
            }
        }

        // Only one participant didn't complete
        return map.keySet().iterator().next();
    }
}
