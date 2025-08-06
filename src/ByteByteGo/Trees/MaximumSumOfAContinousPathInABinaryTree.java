package ByteByteGo.Trees;

public class MaximumSumOfAContinousPathInABinaryTree {

    public static int maxSum = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private static int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(maxPathSumHelper(root.left), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right), 0);

        maxSum = Math.max(maxSum, root.data + leftSum + rightSum);

        return root.data + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-10);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(11);

        root.left.right = new TreeNode(-7);
        root.left.right.left = new TreeNode(-1);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(-3);

        System.out.println(maxPathSum(root));

    }
}
