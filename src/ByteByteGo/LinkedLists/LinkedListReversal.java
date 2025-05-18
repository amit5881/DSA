package ByteByteGo.LinkedLists;

import static ByteByteGo.LinkedLists.Node.printLinkedList;

public class LinkedListReversal {

    public static Node reverseLinkedListUsingArray(Node head) {
        // fetch LL length
        int listLength = 0;
        Node node = head;
        while (node != null) {
            listLength++;
            node = node.next;
        }

        // create an array
        int[] tempArr = new int[listLength];
        node = head;
        for (int i = 0; i < listLength; i++) {
            tempArr[i] = node.val;
            node = node.next;
        }

        // create list from array
        Node result = new Node(tempArr[listLength - 1]);
        Node ptrResult = result;
        for (int j = tempArr.length - 2; j >= 0; j--) {
            ptrResult.next = new Node(tempArr[j]);
            ptrResult = ptrResult.next;
        }

        return result;
    }

    private static Node reverseLinkedListIterative(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node reverseLinkedListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(4, new Node(7, new Node(3)))));
        printLinkedList(head);
        Node result = reverseLinkedListRecursive(head);
        System.out.println();
        printLinkedList(result);
    }
}
