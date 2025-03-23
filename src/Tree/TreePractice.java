package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreePractice {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeNode buildTree() {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        if (data == -1) return null;

        TreeNode node = new TreeNode(data);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    private static void levelOrderPrettyPrint(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                System.out.println();
                if (!queue.isEmpty()) queue.offer(null);
            } else {
                System.out.print(current.data + " ");
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
    }

    private static TreeNode buildTreeFromLevelOrder() {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(scanner.nextInt());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();

            if (c1 != -1) {
                current.left = new TreeNode(c1);
                queue.offer(current.left);
            }
            if (c2 != -1) {
                current.right = new TreeNode(c2);
                queue.offer(current.right);
            }
        }
        scanner.close();
        return root;
    }

    public static void main(String[] args) {
        //level Order : 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
        TreeNode root = buildTreeFromLevelOrder();
        levelOrderPrettyPrint(root);
    }
}
