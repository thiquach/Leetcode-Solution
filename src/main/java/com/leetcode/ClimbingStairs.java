package main.java.com.leetcode;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int steps = 2;

        System.out.println(steps + " steps " + " climbstairs " + climbStairs(steps));
    }

    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        // Create a dp array to store the number of ways to sum up to each number up to n
        int[] dp = new int[n + 1];

        // Initialize base cases
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp array using the recursive relation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
