package main.java.com.leetcode;

import java.util.Arrays;
// 300 Dynamic Programming
public class lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("lengthOfLIS " + lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        if (len == 1)
            return 1;

        int maxLength = 0;
        int[] dp = new int[len+1];
        Arrays.fill(dp,1);

        for (int i=1; i<len; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i=0; i<dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
