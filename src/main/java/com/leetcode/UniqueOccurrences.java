package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5};
        System.out.println("list  " + Arrays.toString(nums) + " Unique? " + uniqueOccurrences(nums));
    }

    public static boolean uniqueOccurrences(int[] arr) {

        if (arr == null) return false;
        if (arr.length == 1) return true;

        Set<Integer> arrAsSet = new HashSet<>();
        for (int num : arr) {
            if (!arrAsSet.add(num)) {
                return false;
            }
        }
        return true;
    }
}