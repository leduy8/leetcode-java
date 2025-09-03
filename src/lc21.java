package src;

public class lc21 {
    public static void main(String[] args) {
        // Create first sorted list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));

        // Create second sorted list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(7))));

        // Merge them
        ListNode merged = mergeTwoLists(list1, list2);

        // Print result
        printList(merged); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }

        if (list2 != null) {
            cur.next = list2;
        }

        return head.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
