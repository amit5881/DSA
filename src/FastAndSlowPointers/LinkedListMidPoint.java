package FastAndSlowPointers;

public class LinkedListMidPoint {

    private static Node getMiddleElement(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(4, new Node(7, new Node(3)))));

        System.out.println(getMiddleElement(head).val);
    }
}
