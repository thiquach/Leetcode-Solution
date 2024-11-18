package main.java.com.leetcode;

import java.util.Arrays;

public class MaxProfit121 {
    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4}; // ans 5
//        int[] prices = {2,1,2,1,0,1,2};
//        int[] prices = {0,3,8,6,8,6,6,8,2,0,2,7};  // ans 8
        int[] prices = {7,6,4,3,1};
//        int[] prices = {2,4,1};
//        int[] prices = {4,1,5,2,7};
//        int[] prices = {1,2};
        System.out.println(" maxProfit121 " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 1)
            return 0;

        int left = 0;
        int right = 1;
        int low = prices[left];
        int high = 0;
        int[] profit = new int[len];
        int maxProfit = 0;

        while (right < len) {
            profit[right] = prices[right] - low;
            if (profit[right] > maxProfit) {
                maxProfit = profit[right];
            }
            if(low > prices[right]) {
                low = prices[right];
            }
            if (high < prices[right]) {
                high = prices[right];
            }
            right++;
        }
        return maxProfit;
    }
}