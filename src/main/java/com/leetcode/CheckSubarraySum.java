package main.java.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public static void main(String[] args) {
//        int[] nums = {23,2,4,6,7}; // 6
//        int[] nums = {23,2,4,6,6}; // k = 7
//        int[] nums = {1,3,6,0,9,6,9}; // k = 7
//        int[] nums = {1,0}; // k = 2
//        int[] nums = {23,6,9}; // k = 6
//        int[] nums = {1,3,6,0,9,6,9}; // k = 7
//        int[] nums = {4,1,2,3}; // k = 7
//        int[] nums = {23,2,6,2,5}; // k = 6
//        int[] nums = {0,1,0,3,0,4,0,4,0}; // k = 5
//        int[] nums = {0,0}; // k = 5
//        int[] nums = {23,2,4,6,6}; // k = 6
//        int[] nums = {0,1,0,3,0,4,0,4,0}; // k = 5
        int[] nums = {5,2,4}; // k = 5
        int k = 5;
        System.out.println("check subarray sum " + checkSubarraySum(nums, k));
    }

    // Use HashMap to store the remainder of prefix sum mod k. If there are two matching remainders in the HashMap
    // then the sum of the elements of the original array between these two indices  will be divisible by k
    // return true
    public static boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2 || k < 1)
            return false;

        Map<Integer, Integer> remainderMap = new HashMap<>();
        int[] pSum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {

            if (i>0) {
                pSum[i] = pSum[i-1] + nums[i];
            } else {
                pSum[i] = nums[i];
            }

            if ((i > 0 && pSum[i] > 0 && pSum[i] % k == 0) || (pSum[i] == 0 && k == 1)) {
                return true;
            }

            int remainder = pSum[i] % k;

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}
