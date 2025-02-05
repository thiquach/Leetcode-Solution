package main.java.com.leetcode;
// #3105
public class LongestMonotonicSubarray {
    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
//        int[] nums = {3,3,3,3};
//        int[] nums = {3,2,1};
        System.out.println("longest monotonic " + longestMonotonicSubarray(nums));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int length = nums.length;
        int upCount = 1;
        int downCount = 1;
        int count = 0;
        int maxCount = 1;
        int left = 0;
        for (int right=1; right<length; right++, left++) {
            if (nums[left] < nums[right]) {
                upCount++;
                downCount = 1;
            } else if (nums[left] > nums[right]) {
                downCount++;
                upCount = 1;
            } else {
                upCount = 1;
                downCount = 1;
            }
            count = Math.max(upCount, downCount);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
