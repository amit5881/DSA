package ByteByteGo.Trees;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;
    }
}
