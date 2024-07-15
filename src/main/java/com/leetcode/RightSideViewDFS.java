package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 199 BFS
public class RightSideViewDFS {
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
        //[1, 2, 3, nul, 5, nul 4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right= new TreeNode(4);
        System.out.print(" root ");
        root.printBtree(root);
        System.out.println(" \nrightSideView " + rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return null;

        dfsRecursive(root, 0, list);
        return list;
    }

    public static void dfsRecursive(TreeNode root, int level, List<Integer> list) {
        if (list.size() == level) {
            list.add(root.val);
        }

        if (root.right != null) dfsRecursive(root.right, level+1, list);
        if (root.left != null) dfsRecursive(root.left, level+1, list);
    }
}