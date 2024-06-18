package main.java.com.leetcode;

import java.util.Arrays;

public class MaxAverage {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        double maxAverage = findMaxAverage(nums, k);
        System.out.println("nums " + Arrays.toString(nums) + " k " + k + " maxAverage " + maxAverage);
    }

    private static double findMaxAverage(int[] nums, int k) {
        if (k < 1 || k > nums.length)
            return 0;

        double sum = 0;
        for (int i=0; i<k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;
        for (int i=k; i<nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum/k;
    }
}
