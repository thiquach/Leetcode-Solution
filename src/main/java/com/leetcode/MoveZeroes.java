package main.java.com.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main (String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Move zeroes " + Arrays.toString(nums));
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] != 0) {
                left++;
            }

            if (left < right) {
                for (int j=left; j < right; j++) {
                    nums[j] = nums[j+1];
                }
                nums[right] = 0;
                right--;
            }
        }
        System.out.println("move zero " + Arrays.toString(nums));
    }
}
