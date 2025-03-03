package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DICombination {
    private static int counter = 0;
    public static void main(String[] args) {
//        String s = "IIIDIDDD";
//        String s = "DIDI";
//        String s = "DDI";
        System.out.println("DI string match ");
        generateCombinations("", 8);
        System.out.println("Total combinations: " + counter);
    }

    public static void generateCombinations(String prefix, int length) {
        if (prefix.length() == length) {
            System.out.println(prefix);
            generateNumber(prefix);
            counter++;
            return;
        }
        generateCombinations(prefix + "D", length);
        generateCombinations(prefix + "I", length);
    }

    public static void generateNumber(String pattern) {
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

        System.out.println(pattern + " -> " + number);
    }
}
