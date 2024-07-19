package main.java.com.leetcode;

import java.util.Arrays;

// 162 binary search
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};

        int result = findPeakElement(nums);
        System.out.println(" peak " + Arrays.toString(nums) + " result " + result);
    }
    public static int findPeakElement(int[] nums) {
        int len = nums.length;

        if (len == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;

        if (nums[len-1] > nums[len-2])
            return len-1;
        int max =0;
        int result = 0;
        for (int i=1; i<len-1; i++) {
            if (nums[i-1] < nums[i] && nums[i+1] < nums[i]) {
                if (nums[i] > max) {
                    max = nums[i];
                    result = i;
                }
            }
        }
        return result;
    }
}
