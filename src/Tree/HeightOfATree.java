package Tree;

import java.util.Scanner;

public class HeightOfATree {

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

        TreeNode root = new TreeNode(data);
        root.left = buildTree();
        root.right = buildTree();
        return root;
    }

    private static int heightOfATree(TreeNode root) {
        if (root == null) return 0;
        int h1 = heightOfATree(root.left);
        int h2 = heightOfATree(root.right);
        return Math.max(h1, h2) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println(heightOfATree(root));
    }
}
