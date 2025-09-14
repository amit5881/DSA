package ByteByteGo.SortAndSearch;

public class SortLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode secondHead = splitList(head);
        ListNode firstHalfSorted = sortLinkedList(head);
        ListNode secondHalfSorted = sortLinkedList(secondHead);
        return mergeLists(firstHalfSorted, secondHalfSorted);
    }

    private static ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        return secondHalf;
    }

    private static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        printList(head);
        head = sortLinkedList(head);
        System.out.println();
        printList(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
