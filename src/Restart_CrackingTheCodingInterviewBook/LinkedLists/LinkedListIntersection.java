package Restart_CrackingTheCodingInterviewBook.LinkedLists;

public class LinkedListIntersection {

    public static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode linkedListIntersection(ListNode head1, ListNode head2) {
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;

        while (ptr1 != ptr2) {
            ptr1 = ptr1 != null ? ptr1.next : head2;
            ptr2 = ptr2 != null ? ptr2.next : head1;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4,
                                new ListNode(8,
                                        new ListNode(7, new ListNode(2, null))))));
        ListNode head2 = new ListNode(6, new ListNode(4, head1.next.next.next));
        printLinkedList(head1);
        System.out.println();
        printLinkedList(head2);
        System.out.println();
        System.out.println(linkedListIntersection(head1, head2).data);
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }
}
