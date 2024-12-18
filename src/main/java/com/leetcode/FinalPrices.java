package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class FinalPrices {
    public static void main(String[] args) {
//        int[] prices = {8,4,6,2,3};
        int[] prices = {10,1,1,6};
        System.out.println("final prices " + Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPrices(int[] prices) {
        if (prices.length == 0)
            return new int[] {};

        Stack<int[]> stack = new Stack<>();
        int[] result = new int[prices.length];
        for (int i=0; i<prices.length; i++) {
            result[i] = prices[i];
            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                int[] p = stack.pop();
                System.out.println(" pop " + p[0] + " index " + p[1]);
                result[p[1]] = prices[p[1]] - prices[i];
            }
            System.out.println(" push " + prices[i]);
            stack.push(new int[]{prices[i], i});
        }
        System.out.println(" result " + Arrays.toString(result));
        return result;
    }
}