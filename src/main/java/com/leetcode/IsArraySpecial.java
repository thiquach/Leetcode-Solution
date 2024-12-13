package main.java.com.leetcode;

import java.util.Arrays;

// 3152 every pair of its adjacent elements contains two numbers with different parity
public class IsArraySpecial {
    public static void main(String[] args) {
//        int[] nums = {3,4,1,2,6,7,9, 10, 11};
        int[] nums = {1,1};
//        int[][] queries = {{0,1}, {3,4}};
//        int[] nums = {4,3,1,6};
        int[][] queries = {{0,1}};

        boolean[] result = isArraySpecial(nums, queries);
        System.out.print(Arrays.toString(nums) + " is special " + Arrays.toString(result));

    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        int[] sArray = splitToRanges(nums);

        for (int i=0; i<queries.length; i++) {
            result[i] = sArray[queries[i][1]] > queries[i][1] - queries[i][0];
        }
        return result;
    }

    private static int[] splitToRanges(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i=0; i<nums.length; i++) {
            if (i>=1) {
                if (nums[i] % 2 != nums[i-1] % 2) {
                    result[i] = result[i - 1] + 1;
                }
            } else {
                result[i] = 1;
            }
        }
        return result;
    }
}