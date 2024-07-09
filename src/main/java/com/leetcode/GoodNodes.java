package main.java.com.leetcode;

// 1448 Binary DFS
public class GoodNodes {
    public static class TreeNode {
        int val;
        GoodNodes.TreeNode left;
        GoodNodes.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, GoodNodes.TreeNode left, GoodNodes.TreeNode right) {
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
        //[3, 1, 4, 3, null, 1, 5]
        GoodNodes.TreeNode root = new GoodNodes.TreeNode(3);
        GoodNodes.TreeNode left = new GoodNodes.TreeNode(5);
        GoodNodes.TreeNode right = new GoodNodes.TreeNode(4);
        GoodNodes.TreeNode leftLeft = new GoodNodes.TreeNode(3);
        GoodNodes.TreeNode rightLeft = new GoodNodes.TreeNode(1);
        GoodNodes.TreeNode rightRight = new GoodNodes.TreeNode(5);
        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = null;
        root.right.left = rightLeft;
        root.right.right = rightRight;

        // [3, 3, null, 4, 2]
//        GoodNodes.TreeNode root = new GoodNodes.TreeNode(3);
//        GoodNodes.TreeNode left = new GoodNodes.TreeNode(3);
//        GoodNodes.TreeNode leftLeft = new GoodNodes.TreeNode(4);
//        GoodNodes.TreeNode leftRight = new GoodNodes.TreeNode(2);
//        root.left = left;
//        root.right = null;
//        root.left.left = leftLeft;
//        root.left.right = leftRight;

//        [2,null,4,10,8,null,null,4]
//        GoodNodes.TreeNode root = new GoodNodes.TreeNode(2);
//        GoodNodes.TreeNode right = new GoodNodes.TreeNode(4);
//        GoodNodes.TreeNode rightLeft = new GoodNodes.TreeNode(10);
//        GoodNodes.TreeNode rightRight = new GoodNodes.TreeNode(8);
//        GoodNodes.TreeNode rightRightLeft = new GoodNodes.TreeNode(4);
//        root.left = null;
//        root.right = right;
//        root.right.left = rightLeft;
//        root.right.right = rightRight;
//        root.right.right.left = rightRightLeft;

        System.out.print(" root ");
        root.printBtree(root);
        System.out.println(" goodNodes " + goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        int maxValue = -10001;
        return countGoodNode(root, maxValue);
    }

    private static int countGoodNode(TreeNode curr, int maxVal) {
        if (curr == null)
            return 0;

        if (curr.val >= maxVal) {
            int left = countGoodNode(curr.left, curr.val);
            int right = countGoodNode(curr.right, curr.val);
            return 1+left+right;
        } else {
            int left = countGoodNode(curr.left, maxVal);
            int right = countGoodNode(curr.right, maxVal);
            return left+right;
        }
    }
}

