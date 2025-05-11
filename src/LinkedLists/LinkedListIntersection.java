package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersection {

    public static Node linkedListIntersectionUsingHashSet(Node head1, Node head2) {
        Set<Node> nodeSet = new HashSet<>();
        while (head1 != null) {
            nodeSet.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (nodeSet.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;
    }

    public static Node linkedListIntersection(Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;

        while (ptr1 != ptr2) {
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, new Node(3, new Node(4, new Node(8, new Node(7, new Node(2))))));

        Node head2 = new Node(6, new Node(4, head1.next.next.next));

        System.out.println(linkedListIntersection(head1, head2).val);

    }
}
