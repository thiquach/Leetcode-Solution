package main.java.com.leetcode;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> myQueue;

    public MyQueue() {
        myQueue = new Stack<>();
    }

    public void push(int x) {
        myQueue.push(x);
    }

    public int pop() {
        int result = 0;
        if (!myQueue.isEmpty()) {
            result = myQueue.get(0);
            myQueue.remove(0);
        }
        return result;
    }

    public int peek() {
        int result = 0;
        if (!myQueue.isEmpty()) {
            result = myQueue.get(0);
        }
        return result;
    }

    public boolean empty() {
        return myQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println("push 1");
        System.out.println("push 2");
        System.out.println(myQueue.peek()); // 1
        System.out.println(myQueue.pop()); // 1
        System.out.println(myQueue.empty()); // 1
    }
}
