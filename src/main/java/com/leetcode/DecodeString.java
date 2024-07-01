package main.java.com.leetcode;

import java.util.Stack;

// 394
public class DecodeString {
    public static void main (String[] args) {
        String s = "3[a]2[bc]";
        //String s = "2[abc]3[cd]ef";
        String decoded = decodeString(s);
        System.out.println("\ncode " + s + " decoded " + decoded);
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        StringBuilder decodeString = new StringBuilder();
        int k = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                count = countStack.pop();
                decodeString = stringStack.pop();
                for (int i=0; i<count; i++) {
                    decodeString.append(currentString);
                }
                currentString = decodeString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
