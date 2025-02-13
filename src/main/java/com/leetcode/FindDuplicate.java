package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("list  " + Arrays.toString(nums) + " duplicate " + findDuplicate(nums));
    }

    public static int findDuplicate (int[] nums) {
        if ((nums == null) || (nums.length == 1))
            return 0;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return nums.length;
    }
}
