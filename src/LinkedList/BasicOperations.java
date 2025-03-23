package LinkedList;

public class BasicOperations {

    private static class ListNode {
        int data;
        ListNode next;
        protected ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode pushFront(ListNode root, ListNode node) {
        node.next = root;
        return node;
    }

    public static ListNode pushBack(ListNode root, ListNode node) {
        ListNode temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return root;
    }

    public static ListNode insertAtPosition(ListNode root, ListNode node, int pos) {
        ListNode temp = root;
        if (pos == 0) {
            node.next = root.next;
            return node;
        }
        while (pos != 1) {
            temp = temp.next;
            pos--;
        }
        node.next = temp.next;
        temp.next = node;
        return root;
    }

    public static int searchIndex(ListNode root, int x) {
        int index = 0;
        while (root.data != x) {
            root = root.next;
            index++;
        }
        return index;
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.data + "->");
            root = root.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(2);
        root.next = new ListNode(3);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(5);
        printList(root);

        ListNode node = new ListNode(1);
        System.out.println();
        root = pushFront(root,  node);
        printList(root);
        System.out.println();
        root = pushBack(root, new ListNode(6));
        printList(root);

        System.out.println();
        root = insertAtPosition(root, new ListNode(9), 3);
        printList(root);

        System.out.println();
        System.out.printf("Index: " + searchIndex(root, 9));
    }


}
