package main.java.com.leetcode;

import javafx.util.Pair;

import java.util.*;

// 739 monotonic stack
public class DailyTemperatures {
    public static void main(String[] args) {

        int[] nums = new int[] {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(nums);
        System.out.println("Daily Temperatures " + Arrays.toString(result));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int index = stack.pop()[1];
                result[index] = i - index;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
