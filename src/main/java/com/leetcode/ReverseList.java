package main.java.com.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Leetcode 206
 */
public class ReverseList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        //TreeNode head = new TreeNode [1.2.3.4.5];
        ListNode head = new ListNode (1);
        head.next = new ListNode (2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (4);
        head.next.next.next.next = new ListNode (5);

        printList(head);
        ListNode newHead = reverseList(head);
        printList(newHead);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode findTail (ListNode head) {
        ListNode tail = head;
        while (head != null) {
            tail = head;
            head = head.next;
        }
        return tail;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode temp;

        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
