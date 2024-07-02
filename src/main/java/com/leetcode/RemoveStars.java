package main.java.com.leetcode;

import java.util.Stack;

public class RemoveStars {
    public static void main (String[] args) {
        String s = "leet**cod*e";
        String noStars = removeStars(s);
        System.out.println("\nremoveStar " + noStars);
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
