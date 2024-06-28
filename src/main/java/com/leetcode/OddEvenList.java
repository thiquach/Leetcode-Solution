package main.java.com.leetcode;

public class OddEvenList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode head;

    public OddEvenList() {
        this.head = null;
    }

    public void prepend(int data) {
        ListNode newHead = new ListNode(data);

        newHead.next = this.head;
        this.head = newHead;
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

    public void printLinkedList() {
        ListNode current = this.head;

        while (current != null) {
            System.out.println(" " + current.val);
            current = current.next;
        }
        System.out.println();
    }

    public void printList(ListNode list) {
        ListNode current = list;

        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
        System.out.println();
    }

    public int countNode(ListNode head) {
        if (head == null)
            return 0;
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public ListNode findTail(ListNode head) {
        if (head == null)
            return null;

        ListNode current = head;
        ListNode tail = null;
        while (current != null) {
            tail = current;
            current = current.next;
        }
        return tail;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        int length = countNode(head);
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        ListNode current = head;
        int countEven = 0;
        for (int i=0; i<length; i++) {
            if (current != null) {
                ListNode node = new ListNode(current.val);
                if (i % 2 != 0) {
                    countEven++;
                    evenDummy.next = node;
                    evenDummy = evenDummy.next;
                } else {
                    oddDummy.next = node;
                    oddDummy = oddDummy.next;
                }
            }
            current = current.next;
        }
        ListNode all = findTail(odd.next);
        for (int i=0; i<countEven; i++) {
            if(even.next != null) {
                ListNode node = new ListNode(even.next.val);
                all.next = node;
                even = even.next;
                all = all.next;
            }
        }
        return odd.next;
    }

    public static void main (String[] args) {
        OddEvenList oddEvenList = new OddEvenList();

        oddEvenList.append(1);
        oddEvenList.append(2);
        oddEvenList.append(3);
        oddEvenList.append(4);
        oddEvenList.append(5);
        oddEvenList.append(6);
        oddEvenList.printList(oddEvenList.oddEvenList(oddEvenList.head));
    }
}
