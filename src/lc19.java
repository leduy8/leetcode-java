package src;

public class lc19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Make a dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;


        // Move fast n step ahead of slow
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both until fast hit the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
