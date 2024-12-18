package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class GetFinalState {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        System.out.println("get final state " + Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        if (nums.length == 0)
            return new int[] {};

        while (k > 0) {
            int smallest = Integer.MAX_VALUE;
            int index = 0;
            for (int i=0; i<nums.length; i++) {
                if (smallest > nums[i]) {
                    smallest = nums[i];
                    index = i;
                }
            }
            nums[index] = smallest * multiplier;
            k--;
        }

        return nums;
    }
}
