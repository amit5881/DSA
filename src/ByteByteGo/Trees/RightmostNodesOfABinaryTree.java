package ByteByteGo.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightmostNodesOfABinaryTree {

    public static List<Integer> rightmostNodesOfABinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) return result;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == levelSize - 1) result.add(node.data);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(11);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        printInorderTraversal(root);
        List<Integer> result = rightmostNodesOfABinaryTree(root);
        System.out.println();
        System.out.println(result);

    }

    private static void printInorderTraversal(TreeNode root) {
        if (root == null) return;
        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }
}
