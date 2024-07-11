package main.java.com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
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
        }
    }

    public static void main(String[] args) {
//        [5,4,8,11,null,13,4,7,2,null,null,null,1] target 8
//        [1,null,2,null,3,null,4,null,5] target 3
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = null;
        root.right.right.right = new TreeNode( 4);
        root.right.right.left = null;
        root.right.right.right.right = new TreeNode(5);

        printBtree(root);
        int result = pathSum(root, 3);
        System.out.println("\n PathSum3 " + result);
        System.out.println();
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        int result = 0;
        result += pathSumChecker(root, targetSum, 0L);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    private static int pathSumChecker(TreeNode root, int targetSum, long currSum) {
        if (root == null)
            return 0;

        int counter = 0;
        currSum += root.val;
        if (currSum == targetSum) {
            counter += 1;
        }
        counter += pathSumChecker(root.left, targetSum, currSum);
        counter += pathSumChecker(root.right, targetSum, currSum);
        return counter;
    }
}
