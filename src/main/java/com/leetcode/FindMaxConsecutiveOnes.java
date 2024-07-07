package main.java.com.leetcode;

import java.util.Arrays;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(" findMaxOnes " + Arrays.toString(nums) + " result " + result);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max = 0;
        int current_one_count = 0;

        for (int i=0; i<len; i++) {
            if (nums[i] == 1) {
                current_one_count += 1;
                max = Math.max(max, current_one_count);
            } else {
                current_one_count = 0;
            }
        }

        return max;
    }
}
