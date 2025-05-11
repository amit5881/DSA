package LinkedLists;

import static LinkedLists.List.printLinkedList;

public class RemoveKthLastNode {

    public static List removeKthLastNode(List head, int k) {
        List dummy = new List(-1);
        dummy.next = head;

        List trailer = dummy;
        List leader = dummy;

        // move leader to the k steps ahead
        for (int i = 0; i < k; i++) {
            leader = leader.next;
            if (leader == null) {
                return leader; // if k > list length no nodes removed and return null;
            }
        }

        // move leader to the end of the linked list
        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }

        // delete the node b/w trailer and leader
        trailer.next = trailer.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        List head = new List(1);
        head.next = new List(2);
        head.next.next = new List(4);
        head.next.next.next = new List(7);
        head.next.next.next.next = new List(3);

        printLinkedList(head);

        List result = removeKthLastNode(head, 2);
        System.out.println();
        printLinkedList(result);
    }
}
