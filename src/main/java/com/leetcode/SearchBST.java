package main.java.com.leetcode;

public class SearchBST {
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
        SearchBST.TreeNode root = new SearchBST.TreeNode(4);
        SearchBST.TreeNode left = new SearchBST.TreeNode(2);
        SearchBST.TreeNode right = new SearchBST.TreeNode(7);
        SearchBST.TreeNode leftLeft = new SearchBST.TreeNode(1);
        SearchBST.TreeNode leftRight = new SearchBST.TreeNode(3);
        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;

        int key = 2;
        TreeNode result = searchBST(root, key);
        if (result != null)
            System.out.println("val found " + result.val);
        else
            System.out.println("value not found");
    }

    public static TreeNode searchBST(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key)
            return root;

        if (key < root.val) {
            return searchBST(root.left, key);
        } else {
            return searchBST(root.right, key);
        }
    }
}
