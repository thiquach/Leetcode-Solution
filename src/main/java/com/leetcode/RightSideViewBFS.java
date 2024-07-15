package main.java.com.leetcode;

import javafx.util.Pair;
import java.util.*;

public class RightSideViewBFS {
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
        System.out.println(" \nrightSideView " + rightSideViewBfs(root));
    }

    private static List<Integer> rightSideViewBfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();

            if (!map.containsKey(level)) {
                map.put(level, node.val);
            }

            if (node.right != null) {
                queue.add (new Pair<>(node.right, level + 1));
            } else if (node.left != null) {
                queue.add (new Pair<>(node.left, level + 1));
            }
        }

        for (int i : map.values()) {
            list.add(i);
        }

        return list;
    }
}
