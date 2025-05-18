package ByteByteGo.LinkedLists;

import static ByteByteGo.LinkedLists.Node.printLinkedList;

public class RemoveKthLastNode {

    public static Node removeKthLastNode(Node head, int k) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node trailer = dummy;
        Node leader = dummy;

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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(3);

        printLinkedList(head);

        Node result = removeKthLastNode(head, 2);
        System.out.println();
        printLinkedList(result);
    }
}
