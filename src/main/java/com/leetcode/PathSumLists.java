package main.java.com.leetcode;

import java.util.*;

// 113 path sum 2
public class PathSumLists {
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
        root.right.right.left = new TreeNode(5);
        root.right.left.left = null;
        root.right.left.right = null;

        printBtree(root);
        List<List<Integer>> result = pathSumList(root, 22);
        System.out.println("\n PathSumList " + result);
        System.out.println();
    }

    public static List<List<Integer>> pathSumList(TreeNode root, int targetSum) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSumChecker(root, targetSum, lists, list);
        return lists;
    }

    private static void pathSumChecker(TreeNode root, int currSum, List<List<Integer>> lists, List<Integer> list) {
        if (root == null)
            return;

        currSum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == 0) {
                lists.add(new ArrayList<>(list));
            }
        } else {
            pathSumChecker(root.left, currSum, lists, list);
            pathSumChecker(root.right, currSum, lists, list);
        }
        list.remove(list.size() - 1); // Backtrack by removing the last element
    }
}
