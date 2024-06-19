package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 3, 4, 3, 4};

        System.out.println("nums " + Arrays.toString(nums) + " singleNumber " + singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
