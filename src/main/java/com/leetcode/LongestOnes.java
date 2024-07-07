package main.java.com.leetcode;

import java.util.Arrays;

// 1004 sliding windows
public class LongestOnes {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int result = longestOnes(nums, k);
        System.out.println(" Longest " + Arrays.toString(nums) + " result " + result);
    }
    public static int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int zeroCount = 0;
        int left = 0;
        int maxOnes = 0;

        for (int right=0; right<len; right++) {
            if (nums[right] == 0) {
                zeroCount += 1;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }
}