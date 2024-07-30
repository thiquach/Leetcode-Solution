package main.java.com.leetcode;

import java.util.Arrays;

// 198 1D DP
public class Rob {
    public static void main(String[] args) {
//        int[] nums = {2,1,1,2};
        int[] nums = {1,3,1,3,100};
//        int[] nums = {6,6,4,8,4,3,3,10};

        int result = rob(nums);
        System.out.println("Rob: " + Arrays.toString(nums) + ", result = " + result);
    }

    public static int rob(int[] nums) {
        int len = nums.length;

        if (len == 0)
            return 0;

        if (len == 1)
            return nums[0];

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[len-1];
    }
}
