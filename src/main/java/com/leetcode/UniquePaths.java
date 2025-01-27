package main.java.com.leetcode;

import java.util.Arrays;

// 62 DP multidimenional
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println("unique paths " + uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m][n];

        for (int i=0; i<m; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
