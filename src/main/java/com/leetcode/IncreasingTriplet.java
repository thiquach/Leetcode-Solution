package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 334
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums = {1,5, 0, 4, 1, 3};
        System.out.println(" triplet? " + increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return false;

        int j = 0;
        int k = 0;
        for (int i=0; i<nums.length - 2; i++) {
            j = i + 1;
            k = j + 1;
            while (k < len) {
                if ((nums[i] < nums[j]) && (nums[j] < nums[k])) {
                    return true;
                } else {
                    k++;
                }
            }
        }
        return false;
    }
}
