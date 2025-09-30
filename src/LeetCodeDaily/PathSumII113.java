package LeetCodeDaily;

import java.util.*;

public class PathSumII113 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, target, 0, result, new ArrayList<>());

        return result;
    }

    private static void dfs(TreeNode root, int target, int currentSum, List<List<Integer>> result, List<Integer> currentPath) {
        if (root == null) return;

        currentSum += root.val;
        currentPath.add(root.val);

        if (root.left == null && root.right == null && currentSum == target) {
            result.add(new ArrayList<>(currentPath));
        }

        dfs(root.left, target, currentSum, result, currentPath);
        dfs(root.right, target, currentSum, result, currentPath);

        currentPath.removeLast();
    }

    static List<List<Integer>> result = new ArrayList<>();
    static int[] arr = new int[1001];
    private static List<List<Integer>> pathSumOptimised(TreeNode root, int target) {
        pathSumOptimised(root, target, 0);
        return result;
    }

    private static void pathSumOptimised(TreeNode root, int target, int index) {
        if (root == null) return;
        arr[index] = root.val;
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i <= index; i++) {
                sum += arr[i];
            }
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i <= index; i++) {
                    list.add(arr[i]);
                }
                result.add(list);
            }
        } else {
            pathSumOptimised(root.left, target, index + 1);
            pathSumOptimised(root.right, target, index + 1);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = buildTree(arr);
        System.out.println(pathSum(root, 22));
        System.out.println(pathSumOptimised(root, 22));
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
