package main.java.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountBadPairs {
    public static void main(String[] args) {
//        int[] nums = {4,1,3,3};
        int[] nums = {1,2,3,4,5};
//        int[] nums = {41,66,20,95,68,24,70,49,31,13,68,40,98,52,22,61,34,24,17,13,2,34,28,87,62,91,22,69,100,24,79,8,4,66,19,52,78,85,75,91,100,22,6,97,57,36,23,46,77,79,89,29,72,51,39,62,31,78,21,91};
//        int[] nums = {56,30,2,73,28,81,75,75,18,63,54,10,69,85,33,89,12,78,57,60,54,65,74,63,53,77};
        System.out.println("bad pairs " + countBadPairs(nums));
    }

    public static long countBadPairs(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0L;

        Map<Long, Integer> numsMap = new HashMap<>();
        int maxCount = 0;
        for (int i=0; i<length; i++) {
            long diff = (long)(nums[i] - i);
            int count = numsMap.getOrDefault(diff, 0) + 1;
            numsMap.put(diff,  count);
            maxCount = Math.max(count, maxCount);
        }

        int goodPairs = 0;
        if (maxCount == length)
            return 0L;
        else {
            for (int count : numsMap.values()) {
                goodPairs += count * (count - 1) / 2;
            }

            long totalPairs = (long) length * (length - 1) / 2;
            return totalPairs - goodPairs;
        }
    }
}
