package src;

public class lc24 {
    public static void main(String[] args) {
    }

    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) { this.val = val; }
        
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;

        // If next 2 nodes still exists
        while (cur != null && cur.next != null) {
            // Swap their vals, keep the node connections
            swapVal(cur, cur.next);
            // Continue to traverse, either it's a node or null
            cur = cur.next.next;
        }

        return head;
    }
    
    public static void swapVal(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
