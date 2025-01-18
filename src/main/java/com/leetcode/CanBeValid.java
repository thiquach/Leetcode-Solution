package main.java.com.leetcode;

import java.util.Stack;
// 2116
public class CanBeValid {
    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";
//        String s = "()()";
//        String locked = "0000";
//        String s = "(((())";
//        String locked = "111111";
//        String s = ")";
//        String locked = "0";
//        String s = "())()))()(()(((())(()()))))((((()())(())";
//        String locked = "1011101100010001001011000000110010100101";
//        String s = "))))(())((()))))((()((((((())())((()))((((())()()))(()";
//        String locked = "1011101100010001001011000000110010100101";
        System.out.println(" s      " + s);
        System.out.println(" locked " + locked);
        System.out.println("canBeValid " + canBeValid(s, locked));
    }

    public static boolean canBeValid(String s, String locked) {
        int length = s.length();

        if (length % 2 != 0 || s.isEmpty())
            return false;

        if (s.charAt(length - 1) == '(' && locked.charAt(length - 1) == '1')
            return false;

        if (s.charAt(0) == ')' && locked.charAt(0) == '1')
            return false;

        Stack<Integer> lockedStack = new Stack<>();
        Stack<Integer> unlockedStack = new Stack<>();
        for (int i=0; i<length; i++) {
            if (locked.charAt(i) == '0') {
                unlockedStack.push(i);
            } else if (s.charAt(i) == '(') {
                lockedStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!lockedStack.isEmpty() && lockedStack.peek() < i) {
                    lockedStack.pop();
                } else if (!unlockedStack.isEmpty() && unlockedStack.peek() < i) {
                    unlockedStack.pop();
                } else
                    return false;
            } else
                return false;
        }

        if (lockedStack.isEmpty())
            return true;
        else {
            while (!lockedStack.empty()) {
                int top = lockedStack.pop();
                if (!unlockedStack.empty() && unlockedStack.peek() > top) {
                    unlockedStack.pop();
                } else
                    return false;
            }
        }
        return lockedStack.isEmpty();
    }
}