package main.java.com.leetcode;

import java.util.Arrays;
// 2460
public class ApplyOperations {
    public static void main(String[] args) {
//        int[] nums = {1,2,2,1,1,0};
        int[] nums = {847,847,0,0,0,399,416,416,879,879,206,206,206,272};
        System.out.println("apply operations " + Arrays.toString(applyOperations(nums)));
    }

    public static int[] applyOperations(int[] nums) {
        if (nums.length == 0)
            return new int[] {};

        int prev = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[prev] == nums[i]) {
                nums[prev] = nums[prev] * 2;
                nums[i] = 0;
            }
            prev = i;
        }

        int[] result = new int[nums.length];
        int index = 0;
        for (int num: nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }
        return result;
    }
}