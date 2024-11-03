package Top150.Trees;

public class InvertBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        inOrderTreeTraversal(root);
        System.out.println();
        root = invertTree(root);
        inOrderTreeTraversal(root);
    }

    private static void inOrderTreeTraversal(TreeNode root) {
        if (root != null) {
            inOrderTreeTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTreeTraversal(root.right);
        }
    }
}
