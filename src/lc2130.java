package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc2130 {
    public static void main(String[] args) {
    
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) { 
            this.val = val; 
        }
        
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public int pairSum(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxSum = 0;
        ListNode cur = head;
        
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        
        int pairs = stack.size() / 2;
        cur = head;
        
        for (int i = 0; i < pairs; i++) {
            maxSum = Math.max(maxSum, cur.val + stack.pop());
            cur = cur.next;
        }
        
        return maxSum;
    }
}