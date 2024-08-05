package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 216 backtracking
public class CombinationSum3 {
    public static void main(String[] args) {

        int k = 3;
        int n = 7;
        System.out.println("combination sum k, n " + k + "," + n);
        System.out.println("result " + combinationSum3(k, n));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (k < 2 || k > 9)
            return result;

        if (n < 1 || n > 60)
            return result;

        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>();
        getCombinations(nums, k, n, 0, list, result);
        return result;
    }

    private static void getCombinations(int[] nums, int k, int n, int start, List<Integer> list, List<List<Integer>> result) {

        if (k == 0 && n == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=start; i<nums.length; i++) {
            if (n - nums[i] < 0 || k - 1 < 0) break;
            list.add(nums[i]);
            getCombinations(nums, k - 1, n - nums[i], i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
