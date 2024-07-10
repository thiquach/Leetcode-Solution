package main.java.com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// 112 has path sum
public class HasPathSum {
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

    public static void printBtree(TreeNode root) {
        if (root == null) {
            System.out.print("null");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current != null) {
                System.out.print(" " + current.val);

                // Add children to the queue even if they are null
                if ((current.left != null) || (current.right != null)) {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            } else {
                System.out.print(" null");
            }
//            System.out.println(" \n depth " + depth);
        }
    }

    public static void main(String[] args) {
//        [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = null;
        root.right.left.left = null;
        root.right.left.right = null;

        printBtree(root);
        boolean result = hasPathSum(root, 22);
        System.out.println("\n hasPathSum " + result );
        System.out.println();
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        int currSum = 0;
        return pathSumChecker(root, targetSum, currSum);
    }

    private static boolean pathSumChecker(TreeNode root, int targetSum, int currSum) {
        if (root == null)
            return false;

        currSum += root.val;
        if (root.left == null && root.right == null)
            return currSum == targetSum;

        return pathSumChecker(root.left, targetSum, currSum) || pathSumChecker(root.right, targetSum, currSum);
    }
}
