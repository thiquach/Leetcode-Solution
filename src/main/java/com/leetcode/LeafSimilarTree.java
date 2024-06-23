package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 872
public class LeafSimilarTree {
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
        //[3,5,1,6,2,9,8,null,null,7,4]
        TreeNode root1 = new TreeNode(1);

        //[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);

        System.out.print(" root1 ");
        printBtree(root1);
        System.out.print(" root2 ");
        printBtree(root2);
        System.out.println(" \nleafSimilar " + leafSimilar(root1, root2));
    }

    private static void leafOfTree (TreeNode root, List<Integer> leaves) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        leafOfTree(root.left, leaves);
        leafOfTree(root.right, leaves);
    }

    public static void printBtree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(" " + root.val);
        if (root.left != null) {
            printBtree (root.left);
        }
        if (root.right != null) {
            printBtree(root.right);
        }
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaf = new ArrayList<>();
        leafOfTree(root1, root1Leaf);
        List<Integer> root2Leaf = new ArrayList<>();
        leafOfTree(root2, root2Leaf);
        return root1Leaf.equals(root2Leaf);
    }
}