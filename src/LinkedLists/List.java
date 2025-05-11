package LinkedLists;

public class List {
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

    public static void printLinkedList(List head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
