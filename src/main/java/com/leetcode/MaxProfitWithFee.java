package main.java.com.leetcode;

import java.util.Arrays;

// 714 Dynamic programming
public class MaxProfitWithFee {
    public static void main(String[] args) {
//        int[] prices = {1,3,2,8,4,9}; // fee=2 ans=8
        int[] prices = {1,3,7,5,10,3};  // fee = 3
//        int[] prices = {1,3,2,8,4,9};
        int fee = 3;
        System.out.println("max profit " + maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;

        if (len == 1)
            return 0;

        int profit = 0;
        int effectiveBuy = prices[0];

        System.out.println(" arr " + Arrays.toString(prices) + " fee " + fee);

        for (int i=1; i<len; i++) {
            profit = Math.max(profit,prices[i]-effectiveBuy-fee);
            effectiveBuy = Math.min(effectiveBuy,prices[i] - profit);
        }
        return profit;
    }
}