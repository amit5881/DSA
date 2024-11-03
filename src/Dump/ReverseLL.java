package Dump;

import java.util.Stack;

public class ReverseLL {

	private static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private static void printLinkedList(Node head) {
		Node temp = head;

		while(temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
	}

	private static void reverseAllStack(Node head) {
		Stack<Integer> stack = new Stack<>();

		Node temp = head;
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while(temp != null) {
			temp.data = stack.pop();
			temp = temp.next;
		}
	}

	private static Node reverseALLOptimised(Node head) {
		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	private static Node reverseLLRecursively(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node newHead = reverseLLRecursively(head.next);

		Node next = head.next;
		next.next = head;
		head.next = null;

		return newHead;
	}



	public static void main(String[] args) {
		Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));

		printLinkedList(head);
		head = reverseLLRecursively(head);
		System.out.println();
		printLinkedList(head);
	}
}