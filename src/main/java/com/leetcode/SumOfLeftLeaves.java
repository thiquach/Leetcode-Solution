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
public class SumOfLeftLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
        }
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode [3, 9, 20, null, null, 15, 7];
        TreeNode root = new TreeNode (3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        root.right.left = rightLeft;
        root.right.right = rightRight;

        System.out.println("sum of left leave " + sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sumLeftLeaves = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sumLeftLeaves += root.left.val;
            } else {
                sumLeftLeaves += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            if ((root.right.left != null) || (root.right.right != null)) {
                sumLeftLeaves += sumOfLeftLeaves(root.right);
            }
        }
        return sumLeftLeaves;
    }
}
