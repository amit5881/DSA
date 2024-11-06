package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PreOrderBuildTree {

    private static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node buildTree() {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        if (data == -1) return null;

        Node node = new Node(data);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }

    private static void printTreePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
    }

    private static void levelOrderPrettyPrint(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            if (temp == null) {
                queue.poll();
                System.out.println();
                if (!queue.isEmpty()) queue.offer(null);
            } else {
                queue.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
    }



    public static void main(String[] args) {
        Node root = buildTree();
        printTreePreOrder(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
        System.out.println();
        levelOrderPrettyPrint(root);
    }


}
