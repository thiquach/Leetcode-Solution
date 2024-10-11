package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

// 1590
public class MinSubarray {
    public static void main(String[] args) {
//        int[] nums = new int[] {3,1,4,2}; // 6
//        int[] nums = new int[] {1,2,3}; // 3
//        int[] nums = new int[] {4,4,2}; // 3
        int[] nums = new int[] {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}; // 26
//        int[] nums = new int[] {6,3,5,2}; // 9
//        int[] nums = new int[] {1000000000,1000000000,1000000000}; // 3
        System.out.println("min subarray " + minSubarray(nums, 26));
    }

    public static int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int remainder = (int) (totalSum % p);

        if (remainder == 0) return 0;

        // HashMap to store prefix sum mod p values
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long prefixSum = 0;
        int minLen = len;

        for (int i = 0; i < len; i++) {
            prefixSum += nums[i];

            // Current mod p of the prefix sum
            int currentMod = (int) (prefixSum % p);

            // Adjust currentMod to always be positive
            if (currentMod < 0) {
                currentMod += p;
            }

            // Find the needed mod value to "cancel" out the remainder
            int targetMod = (currentMod - remainder + p) % p;

            // Check if the target mod has been seen before
            if (map.containsKey(targetMod)) {
                int subarrayLength = i - map.get(targetMod);
                minLen = Math.min(minLen, subarrayLength);
            }

            map.put(currentMod, i);
        }

        return (minLen == len) ? -1 : minLen;
    }
}