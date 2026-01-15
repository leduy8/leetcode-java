package src;

public class lc328 {
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
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = even;

        // If the list length is odd, odds get one extra node.
        // If the list length is even, they end together.
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        
        odd.next = firstEven;
        
        return head;
    }
}
