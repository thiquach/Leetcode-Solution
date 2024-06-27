package main.java.com.leetcode;


import java.util.List;

//2095
public class DeleteMiddle {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode head;

    public DeleteMiddle() {
        this.head = null;
    }

    public void prepend(int data) {
        ListNode node = new ListNode(data);

        node.next = this.head;
        this.head = node;
    }

    public void append(int data) {
        ListNode node = new ListNode(data);

        if (this.head == null) {
            this.head = node;
            return;
        }

        ListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void deleteWithValue(int data) {
        if (this.head == null)
            return;
        if (head.val == data) {
            head = head.next;
            return;
        }

        ListNode current = this.head;
        while (current.next != null) {
            if (current.next.val == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public int countNode() {
        if (this.head == null)
            return 0;
        int count = 0;
        ListNode current = this.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null)
            return null;

        int length = countNode();
        int mid = length / 2 + 1;

        if (length == 1) {
            head = null;
            return head;
        }

        if (length == 2) {
            head.next = null;
            return head;
        }

        ListNode current = this.head;
        for (int i=0; i<mid - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    public void printLinkedList() {
        DeleteMiddle.ListNode head = this.head;

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main (String[] args) {
        DeleteMiddle deleteMiddle = new DeleteMiddle();

        deleteMiddle.append(35);
        deleteMiddle.append(55);
        deleteMiddle.append(75);
        deleteMiddle.append(95);
        deleteMiddle.prepend(25);
        deleteMiddle.printLinkedList();
        deleteMiddle.deleteMiddle(deleteMiddle.head);
        deleteMiddle.deleteWithValue(55);
        deleteMiddle.printLinkedList();
    }
}
