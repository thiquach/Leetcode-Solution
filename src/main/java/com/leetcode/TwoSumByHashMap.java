package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumByHashMap {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("[TwoSum] Input: " + Arrays.toString(nums) + ", target = " + target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numPairs = new HashMap<>();
        int len = nums.length;

        for (int i=0; i<len; i++) {
            int num = nums[i];
            if (numPairs.containsKey(target - num)) {
                return new int [] { i, numPairs.get(target-num) };
            }
            numPairs.put(num, i);
        }

        return new int[] {};
    }
}
