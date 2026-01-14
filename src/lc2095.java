package src;

public class lc2095 {
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
            this.val = val; this.next = next;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        int count = 0;
        ListNode cur = head;

        // First pass: count nodes
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int middle = count / 2;

        // Second pass: stop at (middle - 1)
        cur = head;
        for (int i = 0; i < middle - 1; i++) {
            cur = cur.next;
        }

        // Remove middle node
        cur.next = cur.next.next;

        return head;
    }

    public static ListNode deleteMiddleOptimized(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Fast 2 steps, slow 1 step -> Slow will be in the middle
        prev.next = slow.next;

        return head;
    }
}
