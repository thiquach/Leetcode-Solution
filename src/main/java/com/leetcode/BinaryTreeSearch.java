package main.java.com.leetcode;

public class BinaryTreeSearch {
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
        //TreeNode root = new TreeNode [4, 2, 7, 1, 3];
        BinaryTreeSearch.TreeNode root = new BinaryTreeSearch.TreeNode(4);
        BinaryTreeSearch.TreeNode left = new BinaryTreeSearch.TreeNode(2);
        BinaryTreeSearch.TreeNode right = new BinaryTreeSearch.TreeNode(7);
        BinaryTreeSearch.TreeNode leftLeft = new BinaryTreeSearch.TreeNode(1);
        BinaryTreeSearch.TreeNode leftRight = new BinaryTreeSearch.TreeNode(3);
        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;

        TreeNode result = searchBST(root, 2);
        if (result != null)
            System.out.println("val found " + result.val);
        else
            System.out.println("value not found");
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        TreeNode leftResult = searchBST(root.left, val);
        if (leftResult != null) {
            return leftResult;
        }

        return searchBST(root.right, val);
    }
git}
