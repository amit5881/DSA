package Restart_CrackingTheCodingInterviewBook.LinkedLists;


public class RemoveKthLastNodeFromLinkedList {
    public static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode removeNode(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode trailer = dummy;
        ListNode leader = dummy;
        for (int i = 0; i < k; i++) {
            leader = leader.next;
            if (leader == null) return head;
        }

        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }

        trailer.next = trailer.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2, null));
//                        new ListNode(3,
//                                new ListNode(4,
//                                        new ListNode(5, null)))));
        printLinkedList(head);
        head = removeNode(head, 2);
        System.out.println();
        printLinkedList(head);
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }
}
