package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 236 DFS Binary tree
public class LowestCommonAncestor {
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

        public static void printBtree(TreeNode root) {
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

        public static void main(String[] args) {
            //[3,5,1,6,2,0,8,null,null,7,4]
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right= new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            TreeNode p = new TreeNode(7);
            TreeNode q = new TreeNode(4);

            System.out.print(" root ");
            printBtree(root);
            TreeNode result = lowestCommonAncestor(root, p, q);
            System.out.println(" \nLCAncestor " + result.val);
        }

        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;

            if (root.val == p.val || root.val == q.val)
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null)
                return root;
            if (right != null)
                return right;
            else
                return left;
            return (left != null) ? left : right;
        }
    }
}