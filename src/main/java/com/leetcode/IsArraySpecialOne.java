package main.java.com.leetcode;

public class IsArraySpecialOne {
    public static void main(String[] args) {
//        int[] nums = {1};
//        int[] nums = {2,1,4};
        int[] nums = {4,3,1,6};
        System.out.println("is special? " + isArraySpecialOne(nums));
    }

    public static boolean isArraySpecialOne(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            if ((nums[i] & 1) == (nums[i+1] & 1)) {
                return false;
            }
        }
        return true;
    }
}