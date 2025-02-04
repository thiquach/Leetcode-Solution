package main.java.com.leetcode;

public class Check {
    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
        int[] nums = {3,6,10,1,8,9,9,8,9};
        System.out.println(" rotated ? "  + check(nums));
    }

    public static boolean check(int[] nums) {
        int length = nums.length;
        int unsortedCount = 0;
        int index = 0;
        for (index=0; index<length-1; index++) {
            if (nums[index+1] < nums[index]) {
                unsortedCount++;
                break;
            }
        }
        for (index++; index < length - 1; index++) {
            if (nums[index+1] < nums[index]) {
                unsortedCount++;
                break;
            }
        }

        if (unsortedCount == 1) {
            if (index == length - 1) {
                if (nums[length - 1] > nums[0])
                    return false;
                else
                    return true;
            }
        } else
            return unsortedCount != 2;

        return true;
    }
}