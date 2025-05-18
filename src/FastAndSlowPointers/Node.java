package FastAndSlowPointers;

public class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
