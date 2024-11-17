package main.java.com.leetcode;

import java.util.Arrays;

// 122 medium
public class MaxProfit2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
        System.out.println("max profit2 " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 1)
            return 0;

        int right = 1;
        int allProfit = 0;

        while (right < len) {
            if (prices[right - 1] < prices[right]) {
                allProfit += (prices[right] - prices[right -1]);
            }
            right++;
        }
        return allProfit;
    }
}
