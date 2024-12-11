package main.java.com.leetcode;

import java.util.Arrays;

public class MinimumSize {
    public static void main(String[] args) {
        int[] nums = {2,2,4,8};
        int maximumOperations = 4;
        System.out.println("minimum size " + minimumSize(nums, maximumOperations));
    }

    public static int minimumSize(int[] nums, int maxOperation) {
        if (nums.length < 1)
            return 0;

        int len = nums.length;
        Arrays.sort(nums);

        int low = 1;
        int high = nums[len-1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean result = canSplit(nums, mid, maxOperation);

            if (result) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canSplit(int[] nums, int maxPartSize, int maxOperation) {
        int operationNeeded = 0;

        for (int num : nums) {
            if (num > maxPartSize) {
                operationNeeded += (num - 1) / maxPartSize;
                if (operationNeeded > maxOperation) {
                    return false;
                }
            }
        }
        return true;
    }
}