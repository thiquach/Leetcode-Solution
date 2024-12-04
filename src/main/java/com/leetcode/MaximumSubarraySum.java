package main.java.com.leetcode;

import java.util.HashSet;
// 2461
public class MaximumSubarraySum {
    public static void main(String[] args) {
//        int[] nums = {1,5,4,2,9,9,9};
        int[] nums = {1,1,1,7,8,9};
        int k = 3;
        System.out.println("max subarray sum " + maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        if (nums == null || k > nums.length)
            return 0L;

        int left = 0;
        int right = 0;
        int len = nums.length;
        long sum = 0L;
        long maxSum = Integer.MIN_VALUE;
        HashSet<Integer> numsSet = new HashSet<>();

        for (right=0; right < len; right++) {
            if (!numsSet.contains(nums[right])) {
                numsSet.add(nums[right]);
                sum += nums[right];
                System.out.print(" sum " + sum + " ");

                if (right - left + 1 > k) {
                    numsSet.remove(nums[left]);
                    sum -= nums[left];
                    left++;
                }

                if (right - left + 1 == k) {
                    maxSum = Math.max(sum, maxSum);
                    System.out.println(" max " + maxSum);
                }
            } else {
                while (nums[left] != nums[right]) {
                    sum -= nums[left];
                    numsSet.remove(nums[left]);
                    left++;
                }
                left++;
            }
        }
        return (maxSum == Integer.MIN_VALUE) ? 0L : maxSum;
    }
}
