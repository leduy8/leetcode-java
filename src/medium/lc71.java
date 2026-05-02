package src.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/")); // "/home"
        System.out.println(simplifyPath("/home//foo/")); // "/home/foo"
        System.out.println(simplifyPath("/home/user/Documents/../Pictures")); // "/home/user/Pictures"
        System.out.println(simplifyPath("/../")); // "/"
        System.out.println(simplifyPath("/.../a/../b/c/../d/./")); // "/.../b/d"
    }

    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        String[] components = path.split("/");

        for (String dir : components) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        // If stack empty, return root dir
        if (stack.isEmpty()) return "/";

        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }

        return sb.toString();
    }
}
