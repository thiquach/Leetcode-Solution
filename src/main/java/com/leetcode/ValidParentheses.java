package main.java.com.leetcode;

import java.util.Stack;

// Leetcode#20 valid parentheses
public class ValidParentheses {
    public static void main(String[] args) {
//        String ss1 = "(){}[]";
//        System.out.println(ss1 + " isValid? " + isValid(ss1));
//
//        String ss2 = "([{}])";
//        System.out.println(ss2 + " isValid? " + isValid(ss2));
//
//        String ss3 = "([)]";
//        System.out.println(ss3 + " isValid " + isValid(ss3));

        String ss4 = "([}}])";
        System.out.println(ss4 + " isValid " + isValid(ss4));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}