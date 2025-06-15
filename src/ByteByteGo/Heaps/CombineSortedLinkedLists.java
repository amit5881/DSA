package ByteByteGo.Heaps;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CombineSortedLinkedLists {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node combineSortedLinkedLists(List<Node> heads) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        for (Node head : heads) if (head != null) minHeap.add(head);

        Node dummy = new Node(-1);
        Node current = dummy;
        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            if (smallestNode.next != null) minHeap.add(smallestNode.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, new Node(6));
        Node head2 = new Node(1, new Node(4, new Node(6)));
        Node head3 = new Node(3, new Node(7));

        Node result = combineSortedLinkedLists(List.of(head1, head2, head3));
        while (result != null) {
            System.out.print(result.data + " -> ");
            result = result.next;
        }
    }
}
