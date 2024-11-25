package main.java.com.leetcode;

import java.util.Arrays;

// 300
public class LengthOfLIS {
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {0,1,0,3,2,3};
        System.out.println("lengthOfLIS " + lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        if (len == 1)
            return 1;

        int maxLength = 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int j = 0;

        System.out.println("nums " + Arrays.toString(nums));
        for (int i=1; i<len; i++, j=0) {
            if (i==3) {
                System.out.println("here");
            }
            while (j < i) {
                System.out.print("j " + nums[j] + " i " + nums[i] + "   ");
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
                j++;
            }
        }
        System.out.println("\ndp   " + Arrays.toString(dp));
        for (int i=0; i<len; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
