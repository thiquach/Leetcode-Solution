package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
// 1464
public class MaxProduct {
    public static void main(String[] args) {
//        int[] nums = {3,4,5,2};
//        int[] nums = {1,5,4,5};
//        int[] nums = {3,7};
        int[] nums = {1,8,5,4,10,2,6,1,1,1,9};
        System.out.println("max product " + maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        Arrays.sort(nums);

        int highest = nums[nums.length - 1];
        int secondHighest = nums[nums.length - 2];

        return (highest - 1) * (secondHighest - 1);
    }
}