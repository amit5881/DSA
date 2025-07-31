package ByteByteGo.Trees;

public class BinarySearchTreeValidation {

    public static boolean binarySearchTreeValidation(TreeNode root) {
        return isWithinBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isWithinBounds(TreeNode node, int lowerBound, int upperBound) {
        if (node == null) return true;

        if (!(lowerBound < node.data && node.data < upperBound)) return false;

        if (!isWithinBounds(node.left, lowerBound, node.data)) return false;

        return isWithinBounds(node.right, node.data, upperBound);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        printInOrderTraversal(root);
        System.out.println();
        System.out.println(binarySearchTreeValidation(root));
    }

    private static void printInOrderTraversal(TreeNode root) {
        if (root == null) return;
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }
}
