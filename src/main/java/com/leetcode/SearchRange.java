package main.java.com.leetcode;

import java.util.Arrays;
// 34
public class SearchRange {
    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        Arrays.sort(nums);
        System.out.println("searchRange " + Arrays.toString(searchRange(nums,8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;

        System.out.println("target " + target);
        int[] result = new int[] {-1, -1};
        int lowFound = 0;
        int highFound = 0;

        while (low <= high) {
            if (lowFound == 0) {
                if (nums[low] == target) {
                    lowFound++;
                    result[0] = low;
                    continue;
                }
                low++;
            }
            if (highFound == 0) {
                if (nums[high] == target) {
                    highFound++;
                    result[1] = high;
                    continue;
                }
                high--;
            }
            if (lowFound != 0 && highFound !=0) {
                return result;
            }
        }
        return result;
    }
}
