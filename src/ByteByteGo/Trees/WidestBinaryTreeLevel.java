package ByteByteGo.Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class WidestBinaryTreeLevel {

    private static class TreeNodeWithIndex {
        TreeNode node;
        int index;

        public TreeNodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }

        public TreeNode getNode() {
            return this.node;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static int widestBinaryTreeLevel(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<TreeNodeWithIndex> queue = new ArrayDeque<>();
        queue.add(new TreeNodeWithIndex(root, 0));
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            int leftIndex = queue.peek().getIndex();
            int rightIndex = leftIndex;

            for (int i = 0; i < levelSize; i++) {
                TreeNodeWithIndex node = queue.poll();

                if (node.getNode().left != null) {
                    queue.add(new TreeNodeWithIndex(node.getNode().left, 2 * node.getIndex() + 1));
                }
                if (node.getNode().right != null) {
                    queue.add(new TreeNodeWithIndex(node.getNode().right, 2 * node.getIndex() + 2));
                }
                rightIndex = node.getIndex();
            }
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }

        return maxWidth;
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
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(14);

        printInorderTraversal(root);
        System.out.println();
        System.out.println(widestBinaryTreeLevel(root));
    }

    private static void printInorderTraversal(TreeNode root) {
        if (root == null) return;

        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }
}
