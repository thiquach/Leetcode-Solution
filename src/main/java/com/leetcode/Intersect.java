package main.java.com.leetcode;

import java.util.*;
// 350
public class Intersect {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println("intersect " + Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[] {};

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i=0; i< nums1.length; i++) {
            nums1Map.put(nums1[i], nums1Map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i=0; i<nums2.length; i++) {
            if (nums1Map.getOrDefault(nums2[i], 0) > 0) {
                result.add(nums2[i]);
                nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
            }
        }

        int[] arrResult = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            arrResult[i] = result.get(i);
        }
        return arrResult;
    }
}