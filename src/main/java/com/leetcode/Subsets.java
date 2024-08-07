package main.java.com.leetcode;

import java.util.*;
// 78 medium
// {1,2,3}
// output = [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
public class Subsets {
    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3};
        System.out.println("Subset result " + subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null)
            return lists;

        int len = nums.length;
        if (len < 1 || len > 10)
            return lists;

        List<Integer> list = new ArrayList<>();
        getSubsets(nums, 0, list, lists);
        return lists;
    }

    private static void getSubsets(int[] nums, int start, List<Integer> list, List<List<Integer>> lists) {

        // base case
        if (start > nums.length)
            return;

        lists.add(new ArrayList<>(list));

        // recursion case
        for (int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            getSubsets(nums, i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
