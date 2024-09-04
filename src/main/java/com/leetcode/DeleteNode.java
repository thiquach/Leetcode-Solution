package main.java.com.leetcode;

// 450 Binary search tree
public class DeleteNode {
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
//            [5,3,6,2,4,null,7], key = 3
//            Output: [5,4,6,2,null,null,7]
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(4);
            root.right.left = null;
            root.right.right = new TreeNode(7);

            int key = 3;
            System.out.print(" root ");
            printBtree(root);
            System.out.print("\n delete node");
            TreeNode searchResult = searchBST(root, key);
            TreeNode deleteResult = deleteNode(root, key);
            printBtree(deleteResult);
        }

        public static TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                // has 2 children
                TreeNode node = helper(root.right, root);
                root.val = node.val;
            } else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        private static TreeNode helper(TreeNode right, TreeNode root) {
            TreeNode pre = root;
            TreeNode cur = right;
            while (cur.left != null) {
                pre = cur;
                cur = cur.left;
            }
            deleteNode(pre, cur.val);
            return cur;
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
}
