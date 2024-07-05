package main.java.com.leetcode;

import java.util.Arrays;

// 1679
public class MaxOperations {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
//        int[] nums = {3,1,3,4,3};
        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;
        System.out.println("count " + maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int sum = 0;
        int count = 0;

        Arrays.sort(nums);
        while (start < end) {
             sum = nums[start] + nums[end];
             if (sum > k) {
                 end = end - 1;
             } else if (sum < k){
                 start = start + 1;
             } else {
                 count++;
                 start++;
                 end--;
             }
        }
        return count;
    }
}
