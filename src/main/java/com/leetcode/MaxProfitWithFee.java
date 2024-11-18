package main.java.com.leetcode;

import java.util.Arrays;

// 714 Dynamic programming
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println("max profit " + maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;

        if (len <= 1)
            return 0;

        int[] dp = new int[len+1];
        Arrays.fill(dp, 0);

        int maxLength = 0;
        int[] result = lengthOfLIS(prices);

        System.out.println("dp " + Arrays.toString(result));
        for (int i=0; i<result.length; i++) {
            maxLength = Math.max(maxLength, result[i]);
        }
        System.out.println("longest inc " + maxLength);

        int highIndex = 0;
        for (int i=0; i<len; i++) {
            if (result[i] == maxLength) {
                highIndex = i;
                break;
            }
        }
        System.out.println(" index " + highIndex + ", " + prices[highIndex]);

        int lowIndex = 0;
        int start = prices[highIndex];
        int steps = maxLength -1;
        for (int i=highIndex-1; i>=0; i--) {
            if (steps > 0 && prices[i] <= start) {
                start = prices[i];
                steps--;
                if (steps == 0) {
                    lowIndex = i;
                    break;
                }
            }
        }
        System.out.println("low Index " + lowIndex);
        System.out.println("buy@ " + prices[lowIndex] + " sell@ " + prices[highIndex]);
        int profit = prices[highIndex] - prices[lowIndex] - 2;
        System.out.println("profit " + profit);
        return 8;
    }

    private static int[] lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[] {};

        if (len == 1)
            return new int[] {nums[0]};

        int[] dp = new int[len+1];
        Arrays.fill(dp,1);

        for (int i=1; i<len; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
}