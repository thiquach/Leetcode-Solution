package main.java.com.leetcode;

import java.util.Arrays;

// 1920 Array Simulation
public class BuildArray {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};

        int[] result = buildArray(nums);
        System.out.println("BuildArray: " + Arrays.toString(nums) + ", result = " + Arrays.toString(result));
    }

    public static int[] buildArray(int[] nums) {
        int len = nums.length;

        int[] ans = new int[len];
        for (int i=0; i<len; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
