package main.java.com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.LinkedList;
import java.util.Iterator;

public class MergeSortedLists {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode firstListHead;
    ListNode secondListHead;
    ListNode mergedListHead;

    public MergeSortedLists() {
        this.firstListHead = null;
        this.secondListHead = null;
        this.mergedListHead = null;
    }

    public void addFirstNode(int value, int listNumber) {
        ListNode node = new ListNode(value);
        if (listNumber == 1) {
            node.next = this.firstListHead;
            this.firstListHead = node;
        } else if (listNumber == 2) {
            node.next = this.secondListHead;
            this.secondListHead = node;
        }
    }

    public void addLastNode(int value, int listNumber) {
        ListNode node = new ListNode(value);
        if (listNumber == 1) {
            if (this.firstListHead == null) {
                this.firstListHead = node;
            } else {
                ListNode current = this.firstListHead;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        } else if (listNumber == 2) {
            if (this.secondListHead == null) {
                this.secondListHead = node;
            } else {
                ListNode current = this.secondListHead;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }
    }

    public void mergeLists() {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode firstCurrent = this.firstListHead;
        ListNode secondCurrent = this.secondListHead;

        while (firstCurrent != null && secondCurrent != null) {
            if (firstCurrent.val < secondCurrent.val) {
                tail.next = new ListNode(firstCurrent.val);
                firstCurrent = firstCurrent.next;
            } else {
                tail.next = new ListNode(secondCurrent.val);
                secondCurrent = secondCurrent.next;
            }
            tail = tail.next;
        }

        while (firstCurrent != null) {
            tail.next = new ListNode(firstCurrent.val);  // Create new node with the value
            firstCurrent = firstCurrent.next;
            tail = tail.next;
        }

        while (secondCurrent != null) {
            tail.next = new ListNode(secondCurrent.val);  // Create new node with the value
            secondCurrent = secondCurrent.next;
            tail = tail.next;
        }

        this.mergedListHead = dummy.next;
    }

    public void printLinkedList(int listNumber) {
        ListNode head;
        switch (listNumber) {
            case 1:
                head = this.firstListHead;
                break;
            case 2:
                head = this.secondListHead;
                break;
            case 3:
                head = this.mergedListHead;
                break;
            default:
                head = null;
                break;
        }

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedLists merged = new MergeSortedLists();

        merged.addLastNode(3, 1);
        merged.addLastNode(5, 1);
        merged.addLastNode(2, 2);
        merged.addLastNode(4, 2);
        merged.printLinkedList(1);
        merged.printLinkedList(2);

        merged.mergeLists();
        System.out.println("merged ");
        merged.printLinkedList(3);
        merged.printLinkedList(1);
        merged.printLinkedList(2);

    }
}