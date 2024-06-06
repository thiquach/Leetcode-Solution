package main.java.com.leetcode;

import java.util.ArrayList;

public class ValidParentheses {
    public static class Stack {
        static ArrayList<Character> list = new ArrayList<>();

        public boolean isEmpty() {
            return (list.isEmpty());
        }

        public void push (char data) {
            list.add(data);
        }

        public char pop () {
            if (list.isEmpty())
                return '\0';

            char top = list.get(list.size() -1);
            list.remove(list.size() - 1);
            return top;
        }
    }

    public static void main(String[] args) {
        String ss1 = "(){}[]";
        System.out.println(ss1 + " isValid? " + isValid(ss1));

        String ss2 = "([{}])";
        System.out.println(ss2 + " isValid? " + isValid(ss2));

        String ss3 = "([)]";
        System.out.println(ss3 + " isValid " + isValid(ss3));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = (char) stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}