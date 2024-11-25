package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 334
public class IncreasingTriplet {
    public static void main(String[] args) {
//        int[] nums = {1,5, 0, 4, 1, 3};
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {5,4,3,2,1};
//        int[] nums = {1,5,0,4,1,3};
        int[] nums = {20,100,10,12,5,13};
        System.out.println(" triplet? " + increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
