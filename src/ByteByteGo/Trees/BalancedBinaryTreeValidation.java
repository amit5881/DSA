package ByteByteGo.Trees;

public class BalancedBinaryTreeValidation {

    public static boolean balancedBinaryTreeValidation(TreeNode root) {
        return getHeightImbalance(root) != -1;
    }

    private static int getHeightImbalance(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeightImbalance(node.left);
        int rightHeight = getHeightImbalance(node.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(6);

        inorderTraversal(root);

        System.out.println(balancedBinaryTreeValidation(root));
    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
}
