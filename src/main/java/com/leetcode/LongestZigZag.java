package main.java.com.leetcode;


import java.util.ArrayList;
import java.util.List;

// 1372 DFS
public class LongestZigZag {
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
//            [1,null,1, 1,1,null,null,1,1,null,1,null,null,null,1]
//            root =[1,1,1,null,1,null,null,1,1,null,1]
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.left.right.left = new TreeNode(5);
            root.left.right.right = new TreeNode(6);
            root.left.right.left.right = new TreeNode(7);

            System.out.print(" root ");
            printBtree(root);
            System.out.println(" \nlongestZigZag " + longestZigZag(root));
        }

        private static int maxZigZagLength = 0;

        public static int longestZigZag(TreeNode root) {
            if (root == null)
                return 0;

            // choose a direction
            zigzagStart(root.left, 1, 1);
            zigzagStart(root.right, 2, 1);
            return maxZigZagLength;
        }

        private static void zigzagStart(TreeNode root, int currDir, int length) {
            if (root == null)
                return;

            maxZigZagLength = Math.max(maxZigZagLength, length);

            if (currDir == 1) {
                zigzagStart(root.right, 2, length + 1);
                zigzagStart(root.left, 1, 1);
            } else {
                zigzagStart(root.left, 1, length + 1);
                zigzagStart(root.right, 2, 1);
            }
        }
    }
}
