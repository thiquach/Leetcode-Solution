package main.java.com.leetcode;

import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println("minAddToMakeValid " + minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        int minParentheses = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                System.out.println("pop " + ch);
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                minParentheses++;
            }
        }
        return stack.size() + minParentheses;
    }
}
