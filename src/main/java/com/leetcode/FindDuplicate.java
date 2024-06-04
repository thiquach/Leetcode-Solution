package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("number " + Arrays.toString(nums) + " duplicate " + findDuplicate(nums));
    }

    private static int findDuplicate(int[] nums) {
        if ((nums == null) || (nums.length == 1))
            return 0;

        Set<Integer> numsAsSet = new HashSet<>();

        for (int num: nums) {
            if (numsAsSet.contains(num)) {
                return num;
            }
            numsAsSet.add(num);
        }
        return 0;
    }
}
