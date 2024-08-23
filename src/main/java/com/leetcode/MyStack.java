package main.java.com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    private Deque<Integer> myStack;

    public MyStack() {
        myStack = new LinkedList<>();
    }

    public void push(int x) {
        myStack.add(x);
    }

    public int pop() {
        int result = 0;
        if (!myStack.isEmpty()) {
            result = myStack.pollLast();
        }
        return result;
    }

    public int top() {
        if (!myStack.isEmpty()) {
            int peek = myStack.peekLast();
            return peek;
        }
        return 0;
    }

    public boolean empty() {
        if (!myStack.isEmpty())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("push 1");
        System.out.println("push 2");
        System.out.println("top " + myStack.top()); // 2
        System.out.println("pop " + myStack.pop()); // 2
        System.out.println(myStack.empty()); // true
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */