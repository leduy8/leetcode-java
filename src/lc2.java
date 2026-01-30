package src;

public class lc2 {
    public static void main(String[] args) {
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int cache = 0;
        
        while (l1 != null || l2 != null || cache != 0) {
            int curSum = cache;
            
            if (l1 != null) {
                curSum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                curSum += l2.val;
                l2 = l2.next;
            }
            
            cache = curSum / 10;
            dummy.next = new ListNode(curSum % 10);
            dummy = dummy.next;
        }
        
        return res.next;
    }
}
