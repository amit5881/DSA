package FastAndSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class LinkedListLoop {

    public static boolean detectLoopNaive(Node head) {
        Set<Node> visited = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (visited.contains(curr)) return true;
            visited.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public static boolean linkedListLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(linkedListLoop(head));
    }
}
