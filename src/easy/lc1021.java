package src.easy;

// import java.util.ArrayDeque;
// import java.util.Deque;

public class lc1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())")); // ()()()
        System.out.println(removeOuterParentheses("(()())(())(()(()))")); // ()()()()(())
        System.out.println(removeOuterParentheses("()()")); // ""
    }

    // No Stack
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int openCnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (openCnt > 0) sb.append(c);
                openCnt++;
            } else if (c == ')') {
                openCnt--;
                if (openCnt > 0) sb.append(c);
            }
        }

        return sb.toString();
    }
    
    // Stack
    // public static String removeOuterParentheses(String s) {
    //     Deque<Character> stack = new ArrayDeque<>();
    //     StringBuilder sb = new StringBuilder();

    //     for (char c : s.toCharArray()) {
    //         if (c == '(') {
    //             if (!stack.isEmpty()) sb.append(c);
    //             stack.push(c);
    //         } else if (c == ')') {
    //             stack.poll();
    //             if (!stack.isEmpty()) sb.append(c);
    //         }
    //     }

    //     return sb.toString();
    // }
}
