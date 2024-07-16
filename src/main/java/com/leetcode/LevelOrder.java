package main.java.com.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102 BFS level order traversal
public class LevelOrder {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right= new TreeNode(5);
        System.out.print(" root ");
        root.printBtree(root);
        System.out.println(" \nlevelOrder " + levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode current = pair.getKey();
            int level = pair.getValue();

            if (lists.size() == level) {
                lists.add(new ArrayList<>());
            }
            lists.get(level).add(current.val);


            if (current.left != null) {
                queue.add(new Pair<>(current.left, level + 1));
            }

            if (current.right != null) {
                queue.add(new Pair<>(current.right, level + 1));
            }
        }
        return lists;
    }
}
