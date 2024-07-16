package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 144 preorder traversal
public class PreorderTraversal {
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
//        [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right= null;
        System.out.print(" Tree ");
        root.printBtree(root);
        System.out.println();
        System.out.println(" \nPreOrderTraversal " + preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        preorderDFS(root, list);
        return list;
    }

    public static void preorderDFS(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);

        if (root.left != null) {
            preorderDFS(root.left, list);
        }

        if (root.right != null) {
            preorderDFS(root.right, list);
        }
    }
}
