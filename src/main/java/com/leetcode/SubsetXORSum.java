package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetXORSum {
    public static void main(String[] args) {
//        int[] nums = new int[] {5, 1, 6};
        int[] nums = new int[] {10,5,8,3,6,12,2,4,11,7,1,9};
        System.out.println("subsetXORSum - " + subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        if (nums.length == 0)
            return 0;

        List<List<Integer>> result = subsets(nums);
        int size = result.size();
        int total = 0;
        for (int i=0; i<size; i++) {
            total += xor(result.get(i));
        }
        System.out.println("total " + total);
        return total;
    }

    private static int xor(List<Integer> list) {
        int len = list.size();
        if (len == 0)
            return 0;
        int xor = list.get(0);
        for (int i=1; i<len; i++) {
            xor = xor ^ list.get(i);
        }
        return xor;
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null)
            return lists;

        int len = nums.length;
        if (len < 1)
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