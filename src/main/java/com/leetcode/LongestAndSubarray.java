package main.java.com.leetcode;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

// 2419
public class LongestAndSubarray {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
        int[] nums = {1,2,3,3,2,2,3,3,3};
        System.out.println("longest AND subarray " + longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int length = nums.length;

        if (length == 0)
            return 0;

        int maxNum = nums[0];
        for (int i=1; i<length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }
        int maxLen = 0;
        int maxCount = 0;
        for (int i=0; i< length; i++) {
            if (nums[i] == maxNum) {
                maxCount++;
            } else {
                if (maxCount > 0) {
                    maxLen = Math.max(maxCount, maxLen);
                    maxCount = 0;
                }
            }
        }
        maxLen = Math.max(maxCount, maxLen);
        return maxLen;
    }
}