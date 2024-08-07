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
        long setSize = (long) Math.pow(2, len);
        for (int mask=0; mask<setSize; mask++) {
            for (int i=0; i < len; i++) {
                if ((mask & (1 << i)) >> i == 1) {
                    list.add(nums[i]);
                }
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }
}
