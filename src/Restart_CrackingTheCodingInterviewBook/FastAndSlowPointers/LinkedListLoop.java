package Restart_CrackingTheCodingInterviewBook.FastAndSlowPointers;

import ByteByteGo.FastAndSlowPointers.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedListLoop {

    public static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean linkedListLoopNaive(ListNode head) {
        ListNode curr = head;
        Set<ListNode> visited = new HashSet<>();
        while (curr != null) {
            if (visited.contains(curr)) return true;
            visited.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static boolean linkedListLoopOptimised(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(linkedListLoopNaive(head));
        System.out.println(linkedListLoopOptimised(head));
    }
}
