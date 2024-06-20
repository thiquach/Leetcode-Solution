package main.java.com.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class MaxDepth {
    public static class TreeNode {
        int val;
        MaxDepth.TreeNode left;
        MaxDepth.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MaxDepth.TreeNode left, MaxDepth.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode [3, 9, 20, null, null, 15, 7];
        MaxDepth.TreeNode root = new MaxDepth.TreeNode(3);
        MaxDepth.TreeNode left = new MaxDepth.TreeNode(9);
        MaxDepth.TreeNode right = new MaxDepth.TreeNode(20);
        MaxDepth.TreeNode rightLeft = new MaxDepth.TreeNode(1);
        MaxDepth.TreeNode rightRight = new MaxDepth.TreeNode(3);
        root.left = left;
        root.left.left = null;
        root.left.right = null;
        root.right = right;
        root.right.left = rightLeft;
        root.right.right = rightRight;

        int result = maxDepth(root);
        System.out.println("maxDepth " + result);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int sumLeftDepth = maxDepth(root.left);
        int sumRightDepth = maxDepth(root.right);

        return Math.max(sumLeftDepth, sumRightDepth) + 1;
    }
}