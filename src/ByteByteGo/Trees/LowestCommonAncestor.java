package ByteByteGo.Trees;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor;

    public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lowestCommonAncestor;
    }

    private static boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        boolean isNodePOrQ = node == p || node == q;

        boolean leftContainsPOrQ = dfs(node.left, p, q);
        boolean rightContainsPOrQ = dfs(node.right, p, q);

        int count = 0;
        if (isNodePOrQ) count++;
        if (leftContainsPOrQ) count++;
        if (rightContainsPOrQ) count++;

        if (count == 2) {
            lowestCommonAncestor = node;
        }

        return isNodePOrQ || leftContainsPOrQ || rightContainsPOrQ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        System.out.println(getLowestCommonAncestor(root, root.right.left.left, root.right.right).data);
    }
}
