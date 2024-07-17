package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 653 Two Sum IV - Input is a BST
// a BST has left child containing value less than root and right child containing value greater than root
// Use in order traversal to extract the nodes into a list. This is a sorted list. 2 pointers to find sum
public class FindTarget {
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
//        [5,3,6,2,4,null,7], k=9
//        [1] k=2
        TreeNode root = new TreeNode(1);
        System.out.print(" Tree ");
        root.printBtree(root);
        System.out.println();
        System.out.println(" \nfindTarget " + findTarget(root, 2));
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        List<Integer> list = inorderTraversal(root);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k)
                return true;
            else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;

        inorderDFS(root, list);
        return list;
    }

    public static void inorderDFS(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        if (root.left != null) {
            inorderDFS(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            inorderDFS(root.right, list);
        }
    }
}