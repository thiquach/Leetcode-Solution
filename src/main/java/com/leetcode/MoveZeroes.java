package main.java.com.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main (String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Move zeroes " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Moved       " + Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        for (int j=lastNonZeroIndex; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}