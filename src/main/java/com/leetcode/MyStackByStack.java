package main.java.com.leetcode;

import java.util.Stack;

public class MyStackByStack {
    private Stack<Integer> myStack;

    public MyStackByStack() {
        myStack = new Stack<>();
    }

    public void push(int x) {
        myStack.push(x);
    }

    public int pop() {
        int result = 0;
        if (!myStack.isEmpty()) {
            result = myStack.pop();
        }
        return result;
    }

    public int top() {
        int result = 0;
        if (!myStack.isEmpty()) {
            result = myStack.peek();
        }
        return result;
    }

    public boolean empty() {
        if (!myStack.isEmpty())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        MyStackByStack myStack = new MyStackByStack();
        myStack.push(2);
        System.out.println(myStack.pop()); // 1
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
