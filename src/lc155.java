package src;

import java.util.Stack;

public class lc155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        // Input: [[],[-2],[0],[-3],[],[],[],[]]
        // Output: [null,null,null,null,-3,null,0,-2]
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (this.stack.isEmpty()) {
            this.stack.push(val);
            this.minStack.push(val);
            return;
        }

        this.stack.push(val);
        if (this.getMin() >= val) {
            this.minStack.push(val);
        }
    }

    public void pop() {
        int item = this.stack.pop();
        if (item == this.getMin()) {
            this.minStack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}
