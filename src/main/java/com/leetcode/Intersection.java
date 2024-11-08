package main.java.com.leetcode;

import java.util.*;
// 349
public class Intersection {
    public static void main(String[] args) {
//        int[] nums1 = {4,9,5};        int[] nums2 = {2,2};
//        int[] nums2 = {2,2};
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1, nums2);
        System.out.println("intersection " + Arrays.toString(result));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[] {};

        Map<Integer, Integer> nums1Map = builtNumsMap(nums1);
        Map<Integer, Integer> nums2Map = builtNumsMap(nums2);

        nums1Map.keySet().retainAll(nums2Map.keySet());

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            result.add(entry.getKey());
        }


        int[] arrResult = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            arrResult[i] = result.get(i);
        }
        return arrResult;
    }

    private static Map<Integer, Integer> builtNumsMap (int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        return map;
    }
}
