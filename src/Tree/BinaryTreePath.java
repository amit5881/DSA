package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode node) {
        List<String> result = new ArrayList<>();
        dfs(node, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String s, List<String> result) {
        if (node == null) return;
        s += node.val;

        if (node.left == null && node.right == null) {
            result.add(s);
        } else {
            s += "->";
            dfs(node.left, s, result);
            dfs(node.right, s, result);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.left.right = new TreeNode(5);
//        node.left.left = new TreeNode(4);
//
//        node.right = new TreeNode(3);
//        node.right.left = new TreeNode(6);
        List<String> result = binaryTreePaths(node);
        System.out.println(result);
    }
}
