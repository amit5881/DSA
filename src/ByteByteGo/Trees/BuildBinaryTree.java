package ByteByteGo.Trees;

import java.util.HashMap;
import java.util.Map;

public class BuildBinaryTree {

    public static int preOrderIndex = 0;
    public static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public static TreeNode buildBinaryTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }
        return buildSubtree(0, inOrder.length - 1, preOrder, inOrder);
    }

    private static TreeNode buildSubtree(int left, int right, int[] preOrder, int[] inOrder) {
        if (left > right) return null; // nothing to be build between this range

        int val = preOrder[preOrderIndex];
        int inOrderIndex = inOrderIndexMap.get(val);
        TreeNode node = new TreeNode(val);

        preOrderIndex++;

        node.left = buildSubtree(left, inOrderIndex - 1, preOrder, inOrder);
        node.right = buildSubtree(inOrderIndex + 1, right, preOrder, inOrder);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = buildBinaryTree(new int[]{ 5, 9, 2, 3, 4, 7 }, new int[] { 2, 9, 5, 4, 3, 7 });
        printInOrderTraversal(root);
    }

    private static void printInOrderTraversal(TreeNode root) {
        if (root == null) return;
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }
}
