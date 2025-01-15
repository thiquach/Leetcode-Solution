package main.java.com.leetcode;

import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        String s = "([}}])";
        System.out.println("is valid parentheses " + isValidParentheses(s));
    }

    private static boolean isValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return false; // Null or empty strings are invalid
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false; // Mismatch or unmatched closing parenthesis
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false; // Mismatch or unmatched closing bracket
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false; // Mismatch or unmatched closing brace
                    }
                    break;
                default:
                    return false; // Invalid character
            }
        }

        return stack.isEmpty(); // True only if all opening brackets are matched
    }
}
