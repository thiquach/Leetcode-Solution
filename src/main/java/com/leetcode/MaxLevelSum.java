package main.java.com.leetcode;

import javafx.util.Pair;

import java.util.*;

// 1161 BFS
public class MaxLevelSum {
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
//            [1,7,0,7,-8,null,null
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(7);
            root.right = new TreeNode(0);
            root.left.left = new TreeNode(7);
            root.left.right = new TreeNode(-8);
            root.right.left = null;
            root.right.right = null;

            System.out.print(" root ");
            printBtree(root);
            System.out.println(" \nmaxLevelSum " + maxLevelSum(root));
        }

        public static int maxLevelSum(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            queue.add(new Pair<>(root, 0));

            while (!queue.isEmpty()) {
                Pair <TreeNode, Integer> pair = queue.poll();
                TreeNode current = pair.getKey();
                int level = pair.getValue();

                map.put(level, map.getOrDefault(level, 0) + current.val);
//                System.out.println(" put [" + level + "] " + current.val);

                if (current.left != null) {
                    queue.add(new Pair<>(current.left, level + 1));
                }

                if (current.right != null) {
                    queue.add(new Pair<>(current.right, level + 1));
                }
            }

            int maxSum = Integer.MIN_VALUE;
            int maxLevel = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxSum) {
                    maxSum = entry.getValue();
                    maxLevel = entry.getKey();
                }
            }
            return maxLevel + 1;
        }
    }
}
