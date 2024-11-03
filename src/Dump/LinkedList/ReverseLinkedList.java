package Dump.LinkedList;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        Node linkedList = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        printLinkedList(linkedList);
        linkedList = reverseLinkedList(linkedList);
        System.out.println();
        printLinkedList(linkedList);
    }

    private static Node reverseLinkedList(Node linkedList) {
        Node prev = null;
        Node curr = linkedList;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void printLinkedList(Node linkedList) {
        while (linkedList != null) {
            System.out.print(linkedList.data + "->");
            linkedList = linkedList.next;
        }
    }
}
