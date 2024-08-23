package main.java.com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueueByQueue {
    private Deque<Integer> myQueue;

    public MyQueueByQueue() {
        myQueue = new LinkedList<>();
    }

    public void push(int x) {
        myQueue.add(x);
    }

    public int pop() {
        int result = 0;
        if (!myQueue.isEmpty()) {
            result = myQueue.pollFirst();
        }
        return result;
    }

    public int peek() {
        int result = 0;
        if (!myQueue.isEmpty()) {
            result = myQueue.peekFirst();
        }
        return result;
    }

    public boolean empty() {
        return myQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueueByQueue q = new MyQueueByQueue();
        q.push(1);
        q.push(2);
        System.out.println("push 1");
        System.out.println("push 2");
        System.out.println(q.peek()); // 1
        System.out.println(q.pop()); // 2
        System.out.println(q.empty()); // 3
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */