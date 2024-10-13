package main.java.com.leetcode;

import java.util.Objects;
import java.util.Stack;

public class MinOperations {
    public static void main(String[] args) {
//        String[] logs = {"d1/","d2/","../","d21/","./"};
//        String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs = {"d1/","d2/","../","d21/","./"};

        int result = minOperations(logs);
        System.out.println("result " + result);
    }

    public static int minOperations(String[] logs) {
        String twoDots = "..";
        String oneDot = ".";

        Stack<String> stack = new Stack<>();
        stack.push("Main");
        for (int i=0; i<logs.length; i++) {
            String dest = logs[i].substring(0, logs[i].length() - 1);
            if (dest.equals(oneDot)) continue;
            if (dest.equals(twoDots)) {
                if (!stack.isEmpty() && !Objects.equals(stack.peek(), "Main")) {
                    System.out.println("pop " + stack.pop());
                }
            } else {
                System.out.println("push " + dest);
                stack.push(dest);
            }
        }

        int size = stack.size();
        int count = 0;
        for (int i=0; i<size; i++) {
            if (stack.peek().equals("Main")) {
                break;
            } else {
                System.out.println("pop " + stack.pop());
                count++;
            }
        }
        return count;
    }
}