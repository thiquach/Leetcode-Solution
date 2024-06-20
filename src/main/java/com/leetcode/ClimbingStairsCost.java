package main.java.com.leetcode;

import java.util.Arrays;

public class ClimbingStairsCost {
    public static void main(String[] args) {
        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println("\n nums " + Arrays.toString(nums) + " minCost " + minCostClimbingStairs(nums));
    }

    public static int minCostClimbingStairs(int[] cost) {

        int len = cost.length;

        if (len == 0)
            return 0;

        if (len == 1)
            return cost[0];

        int[] dp = new int[len+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i=2; i <= len; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i - 1], dp[i-2] + cost[i - 2]);
            System.out.print(" i=" + i + " $" + dp[i]);
        }

        return dp[len];
    }
}
