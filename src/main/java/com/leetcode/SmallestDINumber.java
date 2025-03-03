package main.java.com.leetcode;

import java.util.*;

// 2375
public class SmallestDINumber {
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
//        String pattern = "DDD";
//        String pattern = "DIDDI";
        System.out.println("smallest DI num " + smallestNumber(pattern));
    }

    public static String smallestNumber(String pattern) {
        int[] result = new int[pattern.length() + 1];
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(num++);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result[i - stack.size() + 1] = stack.pop();
                }
            }
        }

        StringBuilder number = new StringBuilder();
        for (int digit : result) {
            number.append(digit);
        }

        return number.toString();
    }
}