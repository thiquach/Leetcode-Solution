package main.java.com.leetcode;

import java.util.*;

public class Merge2DArrays {
    public static void main(String[] args) {
        int[][] nums1 = {{1,2}, {2,3}, {4,5}};
        int[][] nums2 = {{1,4}, {3,2}, {4,1}};
        System.out.println("merge 2D arrays" + Arrays.deepToString(mergeArrays(nums1, nums2)));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        if (nums1 == null || nums2 == null)
            return new int[][] {};

        Map<Integer, Integer> sumMap = new TreeMap<>();

        for (int[] num: nums1) {
            sumMap.put(num[0], sumMap.getOrDefault(num[0], 0) + num[1]);
        }

        for (int[] num: nums2) {
            sumMap.put(num[0], sumMap.getOrDefault(num[0], 0) + num[1]);
        }

        int[][] result = new int[sumMap.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry: sumMap.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }
        return result;
    }
}
