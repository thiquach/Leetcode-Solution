package main.java.com.leetcode;

import java.util.Arrays;

public class WaysToSplitArray {
    public static void main(String[] args) {
//        int[] nums = {10,4,-8,7};
        int[] nums = {2,3,1,0};
        System.out.println(" ways to split " + waysToSplitArray(nums));
    }

    public static int waysToSplitArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int[] prefixSum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i > 0) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            } else {
                prefixSum[i] = nums[i];
            }
        }

        System.out.println(" num " + Arrays.toString(nums));
        System.out.println(" sum " + Arrays.toString(prefixSum));

        int count = 0;
        int sumLeft = 0;
        int sumRight = 0;

        for (int i=0; i<nums.length - 1; i++) {
            sumLeft = prefixSum[i];
            sumRight = prefixSum[nums.length - 1] - sumLeft;

            if (sumLeft >= sumRight) {
                count++;
                System.out.print(" ++ ");
            }
        }
        return count;
    }
}