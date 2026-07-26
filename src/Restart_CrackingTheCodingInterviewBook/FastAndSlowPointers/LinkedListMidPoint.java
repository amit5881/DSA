package Restart_CrackingTheCodingInterviewBook.FastAndSlowPointers;

public class LinkedListMidPoint {

    public static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode linkedListMidPoint(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(7, null))));

        System.out.println(linkedListMidPoint(node).data);
    }
}
