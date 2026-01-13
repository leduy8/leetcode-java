package src;

import java.util.*;

public class lc735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5}))); // [5, 10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8}))); // []
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5}))); // [10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3, 5, -6, 2, -1, 4}))); // [-6, 2, 4]
    }

    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0) {
            return asteroids;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean alive = true;

            // Only possible collision:
            // stack top moving right, current moving left
            while (alive && !stack.isEmpty() && stack.peek() > 0 && current < 0) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(current)) {
                    stack.pop();               // top dies, current keeps going
                } else if (Math.abs(top) == Math.abs(current)) {
                    stack.pop();               // both die
                    alive = false;
                } else {
                    alive = false;             // current dies
                }
            }

            if (alive) {
                stack.push(current);
            }
        }

        int[] res = new int[stack.size()];
        int i = 0;

        for (Iterator<Integer> it = stack.descendingIterator(); it.hasNext();) {
            res[i++] = it.next();
        }

        return res;
    }
}
