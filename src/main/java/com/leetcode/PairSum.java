package main.java.com.leetcode;

public class PairSum {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head;

    public PairSum() {
        this.head = null;
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

    public void printList(ListNode list) {
        ListNode current = list;

        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        if (head == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;
        int maxTwinSum = 0;
        int sum = 0;
        while (secondHalf != null) {
            sum = firstHalf.val + secondHalf.val;
            maxTwinSum = Math.max(maxTwinSum, sum);
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        return maxTwinSum;
    }

    public static void main (String[] args) {
        PairSum pairSum = new PairSum();

        pairSum.append(5);
        pairSum.append(4);
        pairSum.append(2);
        pairSum.append(1);
        pairSum.printList(pairSum.head);
        System.out.println("maxPairSum " + pairSum.pairSum(pairSum.head));
    }
}
