package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;
// 590
public class PostOrder {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        // post order: Left, Right, Root
        public void printNode(Node root) {
            if (root == null)
                return;

            if (root.children != null) {
                int size = root.children.size();
                for (int i=0; i<size; i++)
                    if (root.children.get(i).children != null) {
                        printNode(root.children.get(i));
                    } else {
                        System.out.print(" " + root.children.get(i).val);
                    }
            }
            System.out.print(" " + root.val);
        }
    }

    public static void main(String[] args) {
//        [1,null,3,2,4,null,5,6]
        List<Node> list = new ArrayList<>();
        list.add(new Node(5));
        list.add(new Node(6));
        Node level2 = new Node(3, list);

        List<Node> list1 = new ArrayList<>();
        list1.add(level2);
        list1.add(new Node(2));
        list1.add(new Node(4));

        Node root = new Node(1, list1);

        root.printNode(root);
        System.out.println(" \nPost order " +  postorder(root));
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        postOrderDFS(root, list);
        return list;
    }

    private static void postOrderDFS(Node root, List<Integer> list) {
        if (root == null)
            return;

        if (root.children != null) {
            int size = root.children.size();
            for (int i=0; i<size; i++)
                if (root.children.get(i).children != null) {
                    postOrderDFS(root.children.get(i), list);
                } else {
                    list.add(root.children.get(i).val);
                }
        }
        list.add(root.val);
    }
}