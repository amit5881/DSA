package ByteByteGo.Trees;

import java.util.Stack;

public class InvertBinaryTree {

    public static void invertBinaryTree(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    public static void invertBinaryTreeIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);

        inorderTreeTraversal(root);
        invertBinaryTreeIterative(root);
        System.out.println();
        inorderTreeTraversal(root);
    }

    private static void inorderTreeTraversal(TreeNode root) {
        if (root == null) return;
        inorderTreeTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTreeTraversal(root.right);
    }
}
