package LinkedList;

public class ReverseALinkedList {

    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseALL(Node list) {
        Node prev = null;
        Node curr = list;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);

        printLL(list);
        list = reverseALL(list);
        System.out.println();
        printLL(list);
    }

    private static void printLL(Node list) {
        while (list != null) {
            System.out.print(list.data + " -> ");
            list = list.next;
        }
    }
}
