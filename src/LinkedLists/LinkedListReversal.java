package LinkedLists;

public class LinkedListReversal {

    public static class List {
        int val;
        List next;
        public List(int val, List next) {
            this.val = val;
            this.next = next;
        }
        public List(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static void printLinkedList(List head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static List reverseLinkedListUsingArray(List head) {
        // fetch LL length
        int listLength = 0;
        List node = head;
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
        List result = new List(tempArr[listLength - 1]);
        List ptrResult = result;
        for (int j = tempArr.length - 2; j >= 0; j--) {
            ptrResult.next = new List(tempArr[j]);
            ptrResult = ptrResult.next;
        }

        return result;
    }

    private static List reverseLinkedListIterative(List head) {
        List curr = head;
        List prev = null;

        while (curr != null) {
            List next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static List reverseLinkedListRecursive(List head) {
        if (head == null || head.next == null) {
            return head;
        }
        List newHead = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        List head = new List(1, new List(2, new List(4, new List(7, new List(3)))));
        printLinkedList(head);
        List result = reverseLinkedListRecursive(head);
        System.out.println();
        printLinkedList(result);
    }
}
