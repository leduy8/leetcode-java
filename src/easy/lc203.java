package src.easy;

public class lc203 {
    public static void main(String[] args) {
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        // Setup dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        recursion(dummy, head, val);
        return dummy.next;
    }

    public static ListNode recursion(ListNode prev, ListNode cur, int val) {
        if (cur == null) return null;
        
        if (cur.val == val) {
            prev.next = cur.next;
            return recursion(prev, cur.next, val);
        }
        
        return recursion(cur, cur.next, val);
    }
}
