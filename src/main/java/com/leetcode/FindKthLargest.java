package main.java.com.leetcode;

import java.util.Arrays;

// 215 Heap Priority Queue
public class FindKthLargest {
    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println("findKthLargest " + Arrays.toString(nums));
        System.out.println("result " + findKthLargest(nums,2));
    }

    public static int findKthLargest(int[] nums, int target) {
        int len = nums.length;

        Arrays.sort(nums);

        return nums[len - target];
    }
}
