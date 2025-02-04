package main.java.com.leetcode;

public class MaxAscendingSum {
    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50};
//        int[] nums = {10,20,30,5,10,50};
        System.out.println("max ascending sum " + maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int length = nums.length;

        int right = 0;
        int sum = 0;
        int maxSum = 0;
        boolean ascending = true;
        for (right=0; right < length - 1; right++) {
            if (nums[right + 1] > nums[right]) {
                sum += nums[right];
            } else {
                sum += nums[right];
                ascending = false;
            }
            if (!ascending) {
                maxSum = Math.max(sum, maxSum);
                sum = 0;
                ascending = true;
            }
        }
        sum += nums[right];
        return Math.max(sum, maxSum);
    }
}
