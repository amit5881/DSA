package Restart_CrackingTheCodingInterviewBook.LinkedLists;

public class LinkedListReversal {

    public static class LinkedList {
        int data;
        LinkedList next;
        public LinkedList(int data, LinkedList next) {
            this.data = data;
            this.next = next;
        }
    }

    public static LinkedList linkedListReversal(LinkedList head) {
        LinkedList currNode = head;
        LinkedList prevNode = null;

        while (currNode != null) {
            LinkedList nextNode = currNode.next;

            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    public static LinkedList linkedListReversalRecursive(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList newHead = linkedListReversalRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1, new LinkedList(2, new LinkedList(3, null)));
        printLinkedList(head);
        head = linkedListReversalRecursive(head);
        System.out.println();
        printLinkedList(head);
    }

    private static void printLinkedList(LinkedList head) {
        while (head != null) {
            System.out.print(head.data + " --> ");
            head = head.next;
        }
    }
}
