package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MaxWidthRamp {
    public static void main(String[] args) {
//        int[] nums = {6,0,8,2,1,5};
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println("maxWidtheRam " + Arrays.toString(nums));
        int result = maxWidthRamp(nums);
        System.out.println("result " + result);
    }

    public static int maxWidthRamp(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int[] maxArray = new int[len];
        int currentMax = nums[len-1];
        for (int i=len-1; i>=0; i--) {
            if (nums[i] > currentMax) {
                maxArray[i] = nums[i];
                currentMax = nums[i];
            } else {
                maxArray[i] = currentMax;
            }
        }

        int left = 0;
        int right = left + 1;
        int width = 0;

        while (right < len && left < len) {
            if (maxArray[right] >= nums[left]) {
                if (nums[right] >= nums[left]) {
                    if (width < right - left) {
                        width = right -left;
                    }
                }
                right++;
            } else {
                left++;
            }
        }
        return width;
    }
}