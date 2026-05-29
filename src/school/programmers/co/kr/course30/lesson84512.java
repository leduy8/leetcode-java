package src.school.programmers.co.kr.course30;

import java.util.Map;

public class lesson84512 {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE")); // 6
        System.out.println(solution("AAAE")); // 10
        System.out.println(solution("I")); // 1563
        System.out.println(solution("EIO")); // 1189
    }

    public static int solution(String word) {
        int answer = 0;
        Map<Character, Integer> vowelMap = Map.of('A', 0, 'E', 1, 'I', 2, 'O', 3, 'U', 4);
        int pos = 0;

        for (char c: word.toCharArray()) {
            answer += vowelMap.get(c) * getOccurByPos(pos++);
        }

        return answer + word.length();
    }

    public static int getOccurByPos(int pos) {
        // Length 1: 1
        // Length 2: 5
        // Length 3: 25
        // Length 4: 125
        // Length 5: 625
        // Total = 1 + 5 + 25 + 125 + 625 = 781
        // Each letter before E contributes 781 words
        // 718, 156, 31, 6, 1
        int num = 0;

        for (int i = 0; i < 5 - pos; i++) {
            num += (int) Math.pow(5, i);
        }

        return num;
    }
}
