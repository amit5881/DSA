package Restart_CrackingTheCodingInterviewBook.LinkedLists;

public class FlattenAMultiLevelLinkedList {

    public static class MultiLevelListNode {
        int data;
        MultiLevelListNode next;
        MultiLevelListNode child;
        public MultiLevelListNode(int data, MultiLevelListNode next, MultiLevelListNode child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
        public MultiLevelListNode(int data, MultiLevelListNode next) {
            this.data = data;
            this.next = next;
            this.child = null;
        }
    }

    public static MultiLevelListNode flattenMultilevelLinkedList(MultiLevelListNode head) {
        if (head == null) return null;

        MultiLevelListNode tail = head;
        while (tail.next != null) tail = tail.next;

        MultiLevelListNode curr = head;

        while (curr != null) {
            if (curr.child != null) {
                tail.next = curr.child;
                curr.child = null;
                while (tail.next != null) tail = tail.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MultiLevelListNode head = new MultiLevelListNode(1,
                new MultiLevelListNode(2,
                        new MultiLevelListNode(3,
                                        new MultiLevelListNode(4,
                                                new MultiLevelListNode(5, null)))));
        head.next.child = new MultiLevelListNode(6,
                new MultiLevelListNode(7, null,
                        new MultiLevelListNode(10, null)));
        head.next.next.next.child = new MultiLevelListNode(8,
                new MultiLevelListNode(9, null),
                new MultiLevelListNode(11, null, null));
        printMultiLevelList(head);
        head = flattenMultilevelLinkedList(head);
        System.out.println();
        printMultiLevelList(head);
    }

    public static void printMultiLevelList(MultiLevelListNode head) {
        print(head);
    }

    private static void print(MultiLevelListNode node) {
        while (node != null) {
            System.out.print(node.data);

            if (node.child != null) {
                System.out.print(" -> [");
                print(node.child);
                System.out.print("]");
            }

            if (node.next != null) {
                System.out.print(" -> ");
            }

            node = node.next;
        }
    }
}
