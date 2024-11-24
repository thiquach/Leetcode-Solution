package main.java.com.leetcode;

import java.util.Arrays;

public class LengthOfLISByDP {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("lengthOfLIS " + lengthOfLISByDP(nums));
    }

    public static int lengthOfLISByDP(int[] nums) {
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

        System.out.println(" dp " + Arrays.toString(dp));
        for (int i=0; i<dp.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        int highIndex = 0;
        for (int i=0; i<len; i++) {
            if (dp[i] == maxLength) {
                highIndex = i;
                break;
            }
        }
        System.out.println(" index " + highIndex);

        int lowIndex = 0;
        int start = nums[highIndex];
        int steps = maxLength -1;
        for (int i=highIndex-1; i>=0; i--) {
            if (steps > 0 && nums[i] <= start) {
                start = nums[i];
                steps--;
                if (steps == 0) {
                    lowIndex = i;
                    break;
                }
            }
        }
        System.out.println("low Index " + lowIndex);
        return maxLength;
    }
}