package main.java.com.leetcode;

import java.util.Arrays;

//1493
public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
       int result = longestSubarray(nums);
        System.out.println(" Longest " + Arrays.toString(nums) + " result " + result);
    }

    public static int longestSubarray(int[] nums) {
        int maxLen = 0;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
