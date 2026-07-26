package Restart_CrackingTheCodingInterviewBook.LinkedLists;

public class PalindromicLinkedList {

    public static class LinkedList {
        int data;
        LinkedList next;
        public LinkedList(int data, LinkedList next) {
            this.data = data;
            this.next = next;
        }
    }

    public static boolean palindromicLinkedList(LinkedList head) {
        LinkedList mid = findMid(head);
        LinkedList secondHead = reverseLinkedList(mid);

        LinkedList ptr1 = head;
        LinkedList ptr2 = secondHead;

        while (ptr2 != null) {
            if (ptr1.data != ptr2.data) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    private static LinkedList reverseLinkedList(LinkedList head) {
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

    private static LinkedList findMid(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1,
                new LinkedList(2,
                        new LinkedList(3,
                                new LinkedList(2,
                                        new LinkedList(1, null)))));

        System.out.println(palindromicLinkedList(head));
    }
}
