package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;
// 94 In order traversal binary tree
public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void printBtree(TreeNode root) {
            if (root == null)
                return;

            System.out.print(" " + root.val);
            if (root.left != null) {
                printBtree(root.left);
            }
            if (root.right != null) {
                printBtree(root.right);
            }
        }
    }

    public static void main(String[] args) {
//        [1,2,3,4,null,null,5]
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right= null;
        System.out.print(" Tree ");
        root.printBtree(root);
        System.out.println();
        System.out.println(" \nInOrderTraversal " + inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        dfs(root, list);
        return list;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        if (root.left != null) {
            dfs(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}
